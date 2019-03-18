package wxmod.Card.Common;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import basemod.abstracts.CustomCard;
import wxmod.Patches.AbstractCardEnum;
import wxmod.Power.Endlessswordpower;
import wxmod.Power.Endlessswordpower2;

public class LucifercomboA extends CustomCard{
	
	public static final String ID = "LucifercomboA";
	private static final CardStrings cardStrings;
	public static final String NAME;
	public static final	String DESCRIPTION;
	public static final String UPGRADE_DESCRIPTION;
	public static final String IMG_PATH = "img/cards/LucifercomboA.png";
	private static final int COST = 1;

	
	
	public LucifercomboA() {
		super(ID, NAME, IMG_PATH, COST, DESCRIPTION,
        		AbstractCard.CardType.ATTACK, AbstractCardEnum.DMC,
        		AbstractCard.CardRarity.COMMON, AbstractCard.CardTarget.ENEMY);;
		this.baseDamage =  3;
		this.baseMagicNumber = this.magicNumber =  2;
	}
	
	@Override
    public void use(AbstractPlayer p, AbstractMonster m) {
		AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p, this.damage, DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
		AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p, this.damage, DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
		if(upgraded) {AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new Endlessswordpower(p, 3), 3));}
		else{AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new Endlessswordpower(p, this.magicNumber), this.magicNumber));
	 } 
		AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(m, p, new Endlessswordpower2(m, this.magicNumber, p), this.magicNumber, AbstractGameAction.AttackEffect.NONE));
		
	}
	
	@Override
    public AbstractCard makeCopy() {
        return new LucifercomboA();
    }
    
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
        	this.rawDescription = UPGRADE_DESCRIPTION;
            initializeDescription();
        }
	
    }
    
    static {
    	cardStrings = CardCrawlGame.languagePack.getCardStrings("LucifercomboA");
        NAME = LucifercomboA.cardStrings.NAME;
        DESCRIPTION = LucifercomboA.cardStrings.DESCRIPTION;
        UPGRADE_DESCRIPTION = LucifercomboA.cardStrings.UPGRADE_DESCRIPTION;
    }
	
}
