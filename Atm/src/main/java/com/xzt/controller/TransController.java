package com.xzt.controller;


import com.xzt.pojo.Card;
import com.xzt.pojo.User;
import com.xzt.service.CardService;
import com.xzt.service.TransService;
import com.xzt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;


@Controller
public class TransController {
    @Autowired
    private CardService cardService;
    @Autowired
    private UserService userService;
    @Autowired
    private TransService transService;


    /**
     * 跳转存钱界面
     * @param cardId
     * @param model
     * @return
     */
    @GetMapping("toSaveMoney/{cardId}")
    public String toSaveMoney(@PathVariable String cardId,Model model){
        model.addAttribute("cardId",cardId);
        return "toSaveMoney";

    }

    /**
     * 跳转到取款界面
     * @param cardId
     * @param model
     * @return
     */
    @GetMapping("toWithdraw/{cardId}")
    public String toWithdraw(@PathVariable String cardId,Model model){
        model.addAttribute("cardId",cardId);
        return "toWithdrawMoney";

    }

    /**
     * 跳转到转账界面
     * @param cardId
     * @param model
     * @return
     */
    @GetMapping("toTrans/{cardId}")
    public String toTrans(@PathVariable String cardId,Model model){
        model.addAttribute("card",cardId);
        return "transMoney";
    }

    /**
     * 存钱
     * @param model
     * @param transMoney
     * @param remark
     * @param cardId
     * @return
     * @throws Exception
     */
   @PostMapping("saveMoney")
   @Transactional
   public String saveMoney(Model model, @RequestParam BigDecimal transMoney, @RequestParam String remark, @RequestParam String cardId) throws Exception {

            //调用cardService更新银行卡信息表中的余额
            cardService.addBalanceByCardId(cardId,transMoney);
            //调用service层方法存入交易记录表
            transService.saveMoney(transMoney,remark,cardId);

            //再查出更新余额后的银行卡信息
            Card card = cardService.findCardByCardId(cardId);
            //通过身份证找到该用户信息
            User user = userService.findUserByIdentityCard(card.getIdentityCard());
            model.addAttribute("user",user);
            model.addAttribute("card",card);
            return "loginSuccess";
    }

    /**
     * 取钱
     * @param model
     * @param transMoney
     * @param remark
     * @param cardId
     * @return
     * @throws Exception
     */
    @PostMapping("withdrawMoney")
    @Transactional
    public String withdrawMoney(Model model, @RequestParam BigDecimal transMoney, @RequestParam String remark, @RequestParam String cardId) throws Exception {

        //查找银行卡信息
        Card currentCard = cardService.findCardByCardId(cardId);
        //如果银行卡信息不为空
        if(currentCard != null){
            //得到数据库中自己的余额
            BigDecimal currentBalance = currentCard.getBalance();
           /* //创建一个余额用来存储取出钱后的余额
            BigDecimal balance = new BigDecimal(0);*/
            //比较取出金额与余额大小，结果是:   -1：小于；   0 ：等于；   1 ：大于；
            //如果小于等于0，则合法
            if((transMoney.compareTo(currentBalance) <= 0)){
                //调用cardService更新银行卡信息表中的余额
                cardService.reduceBalanceByCardId(cardId,transMoney);
                //调用service层方法存入交易记录表
                transService.reduceMoney(transMoney,remark,cardId);
                //再查出更新余额后的银行卡信息
                Card card = cardService.findCardByCardId(cardId);
                //查找用户信息
                User user = userService.findUserByIdentityCard(card.getIdentityCard());
                model.addAttribute("user",user);
                model.addAttribute("card",card);
                return "loginSuccess";
            }
        }
            //查找银行卡信息
            Card card = cardService.findCardByCardId(cardId);
            model.addAttribute("card",card);
            return "withdrawMoneyError";
    }

    /**
     * 转账
     * @param myCardId
     * @param transMoney
     * @param remark
     * @param otherCardId
     * @param model
     * @return
     * @throws Exception
     */
    @PostMapping("transMoney")
    @Transactional
    public String transMoney(@RequestParam String myCardId,@RequestParam BigDecimal transMoney,@RequestParam String remark,@RequestParam String otherCardId,Model model) throws Exception {
            //myCard为自己的银行卡号,otherCardId为对方银行卡号

            //查找当前自己插卡银行卡信息
            Card currentCard = cardService.findCardByCardId(myCardId);

            //获得自己当前银行卡余额
            BigDecimal currentBalance = currentCard.getBalance();

            //比较转账金额与当前银行卡余额大小，结果是:   -1：小于；   0 ：等于；   1 ：大于；
            if(transMoney.compareTo(currentBalance) <= 0){
                //转账
                cardService.transBalanceByCardId(myCardId,transMoney,otherCardId);

                //自己转账记录插入明细表
                transService.transMoney(transMoney,remark,myCardId,otherCardId);

                //再查出更新余额后的银行卡信息
                Card card = cardService.findCardByCardId(myCardId);
                //查出用户信息
                User user = userService.findUserByIdentityCard(card.getIdentityCard());
                model.addAttribute("user",user);
                model.addAttribute("card",card);
                return "loginSuccess";

            }else{
                //查找我的银行卡信息
                Card card = cardService.findCardByCardId(myCardId);
                model.addAttribute("card",card);
                return "transError";
            }
    }

}
