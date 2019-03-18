/*    */ package wxmod.Actions;
/*    */ import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.Settings;
/*    */ 
/*    */ public class RemoveEndlessswordpower2Action extends com.megacrit.cardcrawl.actions.AbstractGameAction
/*    */ {
/*    */   public RemoveEndlessswordpower2Action(AbstractCreature target, AbstractCreature source)
/*    */   {
/* 13 */     this.target = target;
/* 14 */     this.source = source;
/* 15 */     this.actionType = ActionType.WAIT;
/* 16 */     this.duration = Settings.ACTION_DUR_FAST;
/*    */   }
/*    */   
/*    */   public void update()
/*    */   {
/* 21 */     if (this.duration == Settings.ACTION_DUR_FAST) {
/* 22 */       if (this.target.hasPower("Endlessswordpower2"))
/*    */       {
/* 24 */         com.megacrit.cardcrawl.dungeons.AbstractDungeon.actionManager.addToTop(new RemoveSpecificPowerAction(this.target, this.source, "Endlessswordpower2"));
/*    */       }
/*    */       else {
/* 27 */         this.isDone = true;
/*    */       }
/*    */     }
/*    */     
/* 31 */     tickDuration();
/*    */   }
/*    */ }


//在卡牌效果中完全移除状态
//引用代码：AbstractDungeon.actionManager.addToBottom(new RemoveEndlessswordpower2Action(m, p));