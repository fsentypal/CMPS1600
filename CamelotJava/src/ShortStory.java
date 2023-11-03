import com.actions.*;
import com.storygraph.*;

import com.entities.Character;
import com.entities.Place;
import com.entities.Things.ThingNames;
import com.sequences.CharacterCreation;
import com.entities.Item;


public class ShortStory implements IStory {

    public Character knight1, knight2, queen, king, witch, bandit, player;
    
    public Item bread, coin, greenPotion, openScroll, sword, armor, scroll, ring, rock;
    
    public Place farm, spookyPath, forestPath, tavern, courtyard, city, castleBedroom, diningRoom, dungeon, ruins, greatHall;

    public ShortStory() {
        getThings();
    }

    @Override
    public INode getRoot() {
        return new Node("root");
    }

    @Override
    public void getThings() {
    	player = new Character(ThingNames.Player.toString(), Character.BodyType.D, Character.Clothing.Peasant);
        knight1 = new Character(ThingNames.Knight1.toString(), Character.BodyType.D, Character.Clothing.HeavyArmour);
        knight2 = new Character(ThingNames.Knight2.toString(), Character.BodyType.A, Character.Clothing.LightArmour);
        queen = new Character(ThingNames.Queen.toString(), Character.BodyType.A, Character.Clothing.Queen);
        king = new Character(ThingNames.King.toString(), Character.BodyType.H, Character.Clothing.King);
        witch = new Character(ThingNames.Witch.toString(), Character.BodyType.B, Character.Clothing.Witch);
        bandit = new Character(ThingNames.Bandit.toString(), Character.BodyType.B, Character.Clothing.Bandit);

        bread = new Item(ThingNames.Bread.toString(), Item.Items.Bread);
        coin = new Item(ThingNames.Coin.toString(), Item.Items.Coin);
        greenPotion = new Item(ThingNames.GreenPotion.toString(), Item.Items.GreenPotion);
        openScroll = new Item(ThingNames.OpenScroll.toString(), Item.Items.OpenScroll);
        sword = new Item(ThingNames.Sword.toString(), Item.Items.Sword);

        farm = new Place(ThingNames.Farm.toString(), Place.Places.Farm);
        spookyPath = new Place(ThingNames.SpookyPath.toString(), Place.Places.SpookyPath);
        forestPath = new Place(ThingNames.ForestPath.toString(), Place.Places.ForestPath);
        tavern = new Place(ThingNames.Tavern.toString(), Place.Places.Tavern);
        courtyard = new Place(ThingNames.Courtyard.toString(), Place.Places.Courtyard);
        city = new Place(ThingNames.City.toString(), Place.Places.City);
        castleBedroom = new Place(ThingNames.CastleBedroom.toString(), Place.Places.CastleBedroom);
        diningRoom = new Place(ThingNames.DiningRoom.toString(), Place.Places.DiningRoom);
        dungeon = new Place(ThingNames.Dungeon.toString(), Place.Places.Dungeon);
        ruins = new Place(ThingNames.Ruins.toString(), Place.Places.Ruins);
    }

private ActionSequence getInitSequence() {
	var sequence = new ActionSequence();
	sequence.combineWith(new CharacterCreation(player));
	sequence.add(new Create<Place>(farm));
	sequence.add(new Position(player, farm));
	sequence.add(new Create<Item>(bread));
	sequence.add(new Position(bread, farm, "Shelf"));
	sequence.add(new SetCameraFocus(player));
	sequence.add(new Take(player, bread));
	sequence.add(new AddToList(bread));
	sequence.add(new ShowMenu(true));
	sequence.add(new ShowMenu(false));
	sequence.add(new EnableInput(true));
	return sequence;
}
private ActionSequence getDyingKnightHelpSequence() {
	var sequence = new ActionSequence();
	sequence.combineWith(new CharacterCreation(knight1));
	sequence.add(new Create<Place>(forestPath));
	sequence.add(new Position(knight1, forestPath));
	sequence.add(new Position(player, forestPath));
	sequence.add(new Create<Item>(sword));
	sequence.add(new Create<Item>(openScroll));
	sequence.add(new SetDialog("Help I dont have much life left in me please spare me that bread you have"));
	sequence.add(new SetDialog("Give [Give the knight your last piece of bread]"));
	sequence.add(new SetDialog("Reject [Reject the knight's request]"));
	sequence.add(new ShowDialog());
	sequence.add(new Wait(5));
	sequence.add(new HideDialog());
	return sequence;
	
}
private ActionSequence getKnightDiesSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Die(knight1));
	return sequence;
}
private ActionSequence getOnPathWithItemsSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Take(player, sword));
	sequence.add(new Take(player, armor));
	sequence.add(new AddToList(sword));
	sequence.add(new AddToList(armor));
	return sequence;
}
private ActionSequence getKnightSurvivesSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Give(player, bread, knight1));
	sequence.add(new RemoveFromList(bread));
	sequence.add(new SetDialog("Thank you meet me at the tavern for a little treat"));
	sequence.add(new ShowDialog());
	sequence.add(new Wait(3));
	sequence.add(new HideDialog());
	sequence.add(new Exit(knight1, forestPath.getFurniture("WestEnd"), true));
	return sequence;	
}
private ActionSequence getArriveCitySequence() {
	var sequence = new ActionSequence();
	sequence.add(new Create<Place>(city));
	sequence.add(new Position(player, city));
	return sequence;
}
private ActionSequence getKnightTavernSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Create<Place>(tavern));
	sequence.add(new Position(knight1, tavern));
	sequence.add(new Position(player, tavern));
	sequence.add(new SetDialog("this is the knight quest"));
	sequence.add(new ShowDialog());
	sequence.add(new Wait(2));
	sequence.add(new HideDialog());
	return sequence;
	
}
private ActionSequence getKnightGivesItemsSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Give(knight1, armor, player));
	sequence.add(new Give(knight1, sword, player));
	sequence.add(new Give(knight1, greenPotion, player));
	sequence.add(new Give(knight1, openScroll, player));
	sequence.add(new AddToList(sword));
	sequence.add(new AddToList(armor));
	sequence.add(new AddToList(greenPotion));
	sequence.add(new AddToList(openScroll));
	return sequence;
}
private ActionSequence getArriveCourtyardSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Create<Place>(courtyard));
	sequence.add(new Position(player, courtyard));
	sequence.combineWith(new CharacterCreation(knight2));
	sequence.add(new Position(knight2, forestPath));
	return sequence;
}
private ActionSequence getWitchQuestSequence() {
	var sequence = new ActionSequence();
	sequence.combineWith(new CharacterCreation(queen));
	sequence.add(new Create<Place>(greatHall));
	sequence.add(new Position(player, greatHall));
	sequence.add(new Position(queen, greatHall));
	sequence.add(new SetDialog("there is a witch you should fight them"));
	sequence.add(new ShowDialog());
	sequence.add(new Wait(2));
	sequence.add(new HideDialog());
	return sequence;
	
}
private ActionSequence getKnight2ProofSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Position(player, courtyard));
	sequence.add(new SetDialog("You arent a knight Show me proof"));
	sequence.add(new ShowDialog());
	sequence.add(new Wait(3));
	sequence.add(new HideDialog());
	return sequence;
}
private ActionSequence getKnight2LetsYouGoSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Give(player, openScroll, knight2));
	sequence.add(new RemoveFromList(openScroll));
	sequence.add(new SetDialog("Oh you are a knight carry on"));
	sequence.add(new ShowDialog());
	sequence.add(new Wait(2));
	sequence.add(new HideDialog());
	return sequence;
}
private ActionSequence getKnight2EscapeSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Exit(player, courtyard.getFurniture("Exit"), true));
	return sequence;
}
private ActionSequence getKnight2BattleSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Attack(player, knight2, true));
	sequence.add(new Die(knight2));
	return sequence;
}
private ActionSequence getObtainProof2Sequence() {
	var sequence = new ActionSequence();
	sequence.add(new Create<Item>(scroll));
	sequence.add(new AddToList(scroll));
	return sequence;
}
private ActionSequence getSpookyPathSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Create<Place>(spookyPath));
	sequence.add(new Position(player, spookyPath));
	return sequence;
}
private ActionSequence getBanditQuestionsSequence() {
	var sequence = new ActionSequence();
	sequence.combineWith(new CharacterCreation(bandit));
	sequence.add(new Create<Place>(spookyPath));
	sequence.add(new Position(bandit, spookyPath));
	sequence.add(new Position(player, spookyPath));
	sequence.add(new SetDialog("I AM BANDIT I THREATEN"));
	sequence.add(new ShowDialog());
	sequence.add(new Wait(2));
	sequence.add(new HideDialog());
	return sequence;
}
private ActionSequence getBanditLovePotionSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Give(player, greenPotion, bandit));
	sequence.add(new RemoveFromList(greenPotion));
	sequence.add(new SetDialog("Woah I love you now that was a love potion"));
	sequence.add(new ShowDialog());
	sequence.add(new Wait(3));
	sequence.add(new HideDialog());
	sequence.add(new Give(bandit, ring, player));
	sequence.add(new AddToList(ring));
	return sequence;
}

private ActionSequence getBanditRunsAwaySequence() {
	var sequence = new ActionSequence();
	sequence.add(new Create<Item>(rock));
	sequence.add(new AddToList(rock));
	sequence.add(new Attack(player, bandit, true));
	sequence.add(new RemoveFromList(rock));
	sequence.add(new Exit(bandit, spookyPath.getFurniture("EastEnd"), true));
	return sequence;
	
}
private ActionSequence getWitchRiddleSequence() {
	var sequence = new ActionSequence();
	sequence.combineWith(new CharacterCreation(witch));
	sequence.add(new Create<Place>(ruins));
	sequence.add(new Position(witch, ruins));
	sequence.add(new Position(player, ruins));
	sequence.add(new SetDialog("I am witch I challenge you with riddle"));
	sequence.add(new ShowDialog());
	sequence.add(new Wait(3));
	sequence.add(new HideDialog());

	return sequence;
	
}
private ActionSequence getWitchDiesSequence() {
	var sequence = new ActionSequence();
	sequence.add(new SetDialog("Noooo I die now"));
	sequence.add(new ShowDialog());
	sequence.add(new Wait(2));
	sequence.add(new HideDialog());
	sequence.add(new Die(witch));
	
	return sequence;
}

private ActionSequence getYouDieSequence() {
	var sequence = new ActionSequence();
	sequence.add(new SetDialog("Wrong answer i win you die"));
	sequence.add(new ShowDialog());
	sequence.add(new Wait(2));
	sequence.add(new HideDialog());
	sequence.add(new Die(player));
	
	return sequence;
}

private ActionSequence getReturnCourtyardSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Position(player, courtyard));
	return sequence;
}
private ActionSequence getKingdomCongratsSequence() {
	var sequence = new ActionSequence();
	sequence.combineWith(new CharacterCreation(king));
	sequence.add(new Position(queen, greatHall));
	sequence.add(new Position(king, greatHall));
	sequence.add(new Position(player, greatHall));
	sequence.add(new SetDialog("Congrats for killing the witch who do you want to talk to?"));
	sequence.add(new ShowDialog());
	sequence.add(new Wait(4));
	sequence.add(new HideDialog());
	return sequence;
}
private ActionSequence getQueenLoveSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Create<Place>(castleBedroom));
	sequence.add(new Position(queen, castleBedroom));
	sequence.add(new Position(player, castleBedroom));
	sequence.add(new SetDialog("I always loved you"));
	sequence.add(new ShowDialog());
	sequence.add(new Wait(2));
	sequence.add(new HideDialog());
	return sequence;
}
private ActionSequence getHappilyEverAfterSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Give(player, ring, queen));
	sequence.add(new RemoveFromList(ring));
	sequence.add(new SetDialog("You won Happily Ever After"));
	sequence.add(new ShowDialog());
	sequence.add(new Wait(5));
	sequence.add(new HideDialog());
	sequence.add(new FadeOut());
	return sequence;
}
private ActionSequence getQueenTellsYouLeaveSequence() {
	var sequence = new ActionSequence();
	sequence.add(new SetDialog("I dont love you sorry"));
	sequence.add(new ShowDialog());
	sequence.add(new Wait(2));
	sequence.add(new HideDialog());
	sequence.add(new SetDialog("Okay go to the king"));
	sequence.add(new ShowDialog());
	sequence.add(new Wait(2));
	sequence.add(new HideDialog());
	sequence.add(new Exit(player, castleBedroom.getFurniture("Door"), true));
	sequence.add(new Position(king, greatHall));
	sequence.add(new Position(player, greatHall));
	sequence.add(new SetDialog("Will you show me your knight proof"));
	sequence.add(new ShowDialog());
	sequence.add(new Wait(2));
	sequence.add(new HideDialog());
	return sequence;
}
private ActionSequence getKingProofSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Position(king, greatHall));
	sequence.add(new Position(player, greatHall));
	sequence.add(new SetDialog("Will you show me your knight proof"));
	sequence.add(new ShowDialog());
	sequence.add(new Wait(2));
	sequence.add(new HideDialog());
	return sequence;
}
private ActionSequence getHeadKnightSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Give(player, openScroll, king));
	sequence.add(new RemoveFromList(openScroll));
	sequence.add(new SetDialog("You are a knight I am promoting you to head knight"));
	sequence.add(new ShowDialog());
	sequence.add(new Wait(5));
	sequence.add(new HideDialog());
	sequence.add(new SetDialog("You got the second best option Semi Happily Ever After"));
	sequence.add(new ShowDialog());
	sequence.add(new Wait(5));
	sequence.add(new HideDialog());
	sequence.add(new FadeOut());
	return sequence;
}
private ActionSequence getDungeonSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Give(player, scroll, king));
	sequence.add(new RemoveFromList(scroll));
	sequence.add(new SetDialog("Imposter Murderer This is not you"));
	sequence.add(new ShowDialog());
	sequence.add(new Wait(3));
	sequence.add(new HideDialog());
	sequence.add(new Exit(player, greatHall.getFurniture("BasementDoor"), true));
	sequence.add(new Create<Place>(dungeon));
	sequence.add(new Position(player, dungeon));
	sequence.add(new SetDialog("You got the worst option Sadly Ever After"));
	sequence.add(new ShowDialog());
	sequence.add(new Wait(5));
	sequence.add(new HideDialog());
	sequence.add(new FadeOut());
	return sequence;
	
}
private ActionSequence getNowPeasantSequence() {
	var sequence = new ActionSequence();
	sequence.add(new SetDialog("Im the first knight"));
	sequence.add(new ShowDialog());
	sequence.add(new Wait(2));
	sequence.add(new HideDialog());
	sequence.add(new SetDialog("No youre not and it seems you dont have proof We are taking your stuff but you can keep the gold from your journey"));
	sequence.add(new ShowDialog());
	sequence.add(new Wait(8));
	sequence.add(new HideDialog());
	sequence.add(new Create<Item>(coin));
	sequence.add(new Give(king, coin, player));
	sequence.add(new AddToList(coin));
	sequence.add(new SetDialog("You got the second worst option Mediocrely Ever After"));
	sequence.add(new ShowDialog());
	sequence.add(new Wait(5));
	sequence.add(new HideDialog());
	sequence.add(new FadeOut());
	return sequence;
}

private enum NodeLabels
{
    Init,
    DyingKnightHelp,
    KnightDies,
    OnPathWithItems,
    GreatHallQueen,
    KnightSurvives,
    ArriveCity,
    KnightTavern,
    KnightGivesItems,
    WitchQuest,
    Knight2Proof,
    Knight2LetsYouGo,
    Knight2Escape,
    Knight2Battle,
    ObtainProof2,
    SpookyPath,
    BanditQuestions,
    BanditLovePotion,
    BanditRunsAway,
    BanditGivesRing,
    WitchRiddle,
    WitchDies,
    YouDie,
    ReturnCourtyard,
    KingdomCongrats,
    QueenLove,
    HappilyEverAfter,
    QueenTellsYouLeave,
    KingProof,
    HeadKnight,
    Dungeon,
    NowPeasant, 
    ArriveCourtyard
}

@Override
public ActionMap getMap() {
    var map = new ActionMap();

    map.add(NodeLabels.Init.toString(), getInitSequence());
    map.add(NodeLabels.DyingKnightHelp.toString(), getDyingKnightHelpSequence());
    map.add(NodeLabels.KnightDies.toString(), getKnightDiesSequence());
    map.add(NodeLabels.OnPathWithItems.toString(), getOnPathWithItemsSequence());
    map.add(NodeLabels.KnightSurvives.toString(), getKnightSurvivesSequence());
    map.add(NodeLabels.ArriveCity.toString(), getArriveCitySequence());
    map.add(NodeLabels.KnightTavern.toString(), getKnightTavernSequence());
    map.add(NodeLabels.KnightGivesItems.toString(), getKnightGivesItemsSequence());
    map.add(NodeLabels.ArriveCourtyard.toString(), getArriveCourtyardSequence());
    map.add(NodeLabels.WitchQuest.toString(), getWitchQuestSequence());
    map.add(NodeLabels.Knight2Proof.toString(), getKnight2ProofSequence());
    map.add(NodeLabels.Knight2LetsYouGo.toString(), getKnight2LetsYouGoSequence());
    map.add(NodeLabels.Knight2Escape.toString(), getKnight2EscapeSequence());
    map.add(NodeLabels.Knight2Battle.toString(), getKnight2BattleSequence());
    map.add(NodeLabels.ObtainProof2.toString(), getObtainProof2Sequence());
    map.add(NodeLabels.SpookyPath.toString(), getSpookyPathSequence());
    map.add(NodeLabels.BanditQuestions.toString(), getBanditQuestionsSequence());
    map.add(NodeLabels.BanditLovePotion.toString(), getBanditLovePotionSequence());
    map.add(NodeLabels.BanditRunsAway.toString(), getBanditRunsAwaySequence());
    map.add(NodeLabels.WitchRiddle.toString(), getWitchRiddleSequence());
    map.add(NodeLabels.WitchDies.toString(), getWitchDiesSequence());
    map.add(NodeLabels.YouDie.toString(), getYouDieSequence());
    map.add(NodeLabels.ReturnCourtyard.toString(), getReturnCourtyardSequence());
    map.add(NodeLabels.KingdomCongrats.toString(), getKingdomCongratsSequence());
    map.add(NodeLabels.QueenLove.toString(), getQueenLoveSequence());
    map.add(NodeLabels.HappilyEverAfter.toString(), getHappilyEverAfterSequence());
    map.add(NodeLabels.QueenTellsYouLeave.toString(), getQueenTellsYouLeaveSequence());
    map.add(NodeLabels.KingProof.toString(), getKingProofSequence());
    map.add(NodeLabels.HeadKnight.toString(), getHeadKnightSequence());
    map.add(NodeLabels.Dungeon.toString(), getDungeonSequence());
    map.add(NodeLabels.NowPeasant.toString(), getNowPeasantSequence());

    return map;
	}
}
