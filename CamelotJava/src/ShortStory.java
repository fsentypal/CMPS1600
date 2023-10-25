import com.playerInput.*;
import com.actions.*;
import com.sequences.*;
import com.storygraph.*;

import java.util.ArrayList;
import java.util.Optional;

import com.actions.ActionSequence;
import com.entities.Character;
import com.entities.Place;
import com.entities.Things.ThingNames;
import com.playerInput.IPlayerChoice;
import com.sequences.CharacterCreation;
import com.entities.Item;


// ShortStory class that implements IStory
public class ShortStory implements IStory {
	public interface IStory {
	    ActionMap getMap();
	    INode getRoot();
	    void getThings();
	}

    // Declaring characters
    public Character knight1, knight2, queen, king, witch, bandit, player;
    
    // Declaring items
    public Item bread, coin, greenPotion, openScroll, sword;
    
    // Declaring places
    public Place farm, spookyPath, forestPath, tavern, courtyard, city, castleBedroom, diningRoom, dungeon, ruins;

    // Constructor
    public ShortStory() {
        getThings();
    }

    @Override
    public INode getRoot() {
        return new Node("root");
    }

    @Override
    public void getThings() {
        // Instantiating characters
    	player = new Character(ThingNames.Player)
        knight1 = new Character(ThingNames.Knight1);
        knight2 = new Character(ThingNames.Knight2);
        queen = new Character(ThingNames.Queen);
        king = new Character(ThingNames.King);
        witch = new Character(ThingNames.Witch);
        bandit = new Character(ThingNames.Bandit);

        // Instantiating items
        bread = new Item(ThingNames.Bread, Item.Items.Bread);
        coin = new Item(ThingNames.Coin, Items.Coin);
        greenPotion = new Item(ThingNames.GreenPotion, Items.GreenPotion);
        openScroll = new Item(ThingNames.OpenScroll, Items.OpenScroll);
        sword = new Item(ThingNames.Sword, Items.Sword);

        // Instantiating places
        farm = new Place(ThingNames.Farm, Places.Farm);
        spookyPath = new Place(ThingNames.SpookyPath, Places.SpookyPath);
        forestPath = new Place(ThingNames.ForestPath, Places.ForestPath);
        tavern = new Place(ThingNames.Tavern, Places.Tavern);
        courtyard = new Place(ThingNames.Courtyard, Places.Courtyard);
        city = new Place(ThingNames.City, Places.City);
        castleBedroom = new Place(ThingNames.CastleBedroom, Places.CastleBedroom);
        diningRoom = new Place(ThingNames.DiningRoom, Places.DiningRoom);
        dungeon = new Place(ThingNames.Dungeon, Places.Dungeon);
        ruins = new Place(ThingNames.Ruins, Places.Ruins);
    }
}

class Node implements INode {
    private String name;

    public Node(String name) {
        this.name = name;
    }

    @Override
    public String getLabel() {
        return name;
    }

    @Override
    public INode getNextNode(Optional<IPlayerChoice> edge) {
        // Placeholder
        return null;
    }

    @Override
    public Optional<ArrayList<IPlayerChoice>> getOutgoingEdges() {
        // Placeholder
        return Optional.empty();
    }
}

class ActionMap {
    // Placeholder for methods and attributes of the ActionMap class
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
	sequence.add(new AddToList(Bread));
	sequence.add(new ShowMenu(true));
	sequence.add(new EnableInput(true));
	return sequence;
}
private ActionSequence getDyingKnightHelpSequence() {
	var sequence = new ActionSequence();
	sequence.combineWith(new CharacterCreation(knight));
	sequence.add(new Create<Place>(forestPath));
	sequence.add(new Position(knight, forestPath));
	sequence.add(new Position(player, forestPath));
	sequence.add(new Create<Item>(sword));
	sequence.add(new Create<Item>(openScroll))
	sequence.add(new SetDialog("Help! I don't have much life left in me, please spare me that bread you have..."));
	return sequence;
	
}
private ActionSequence getKnightDiesSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Die(knight));
	return sequence;
}
private ActionSequence getOnPathWithItemsSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Take(player, sword));
	sequence.add(new Take(player, armor));
	sequence.add(new AddToList(Sword));
	sequence.add(new AddToList(Armor));
	return sequence;
}
private ActionSequence getKnightSurvivesSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Give(player, bread, knight));
	sequence.add(new RemoveFromList(Bread));
	sequence.add(new SetDialog("Thank you, meet me at the tavern for a little treat ;)"));
	sequence.add(new Exit(knight, ForestPath.WestEnd));
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
	sequence.add(new Create<Place>(Tavern));
	sequence.add(new Position(knight, Tavern));
	sequence.add(new Position(player, Tavern));
	sequence.add(new SetDialog("this is the knight quest"));
	return sequence;
	
}
private ActionSequence getKnightGivesItemsSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Give(knight, armor, player));
	sequence.add(new Give(knight, sword, player));
	sequence.add(new Give(knight, greenPotion, player));
	sequence.add(new Give(knight, openScroll, player));
	sequence.add(new AddToList(Sword));
	sequence.add(new AddToList(Armor));
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
	sequence.combineWith(new CharacterCreation(Queen));
	sequence.add(new Create<Place>(greatHall));
	sequence.add(new Position(player, greatHall));
	sequence.add(new Position(Queen, greatHall));
	sequence.add(new SetDialog("there is a witch you should fight them"));
	return sequence;
	
}
private ActionSequence getKnight2ProofSequence() {
	var sequence = new ActionSequence();
	sequence.add((new Postion(player, courtyard)));
	sequence.add(new SetDialog("You aren't a knight! Show me proof!"));
	return sequence;
}
private ActionSequence getKnight2LetsYouGoSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Give(player, openScroll, knight2));
	sequence.add(new RemoveFromList(openScroll));
	sequence.add(new SetDialog("Oh you are a knight... carry on"));
	return sequence;
}
private ActionSequence getKnight2EscapeSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Exit(player, courtyard.Exit));
	return sequence;
}
private ActionSequence getKnight2BattleSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Attack(player, knight2));
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
	return sequence;
}
private ActionSequence getBanditLovePotionSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Give(player, greenPotion, bandit));
	sequence.add(new RemoveFromList(greenPotion));
	sequence.add(new SetDialog("Woah I love you now that was a love potion"));
	sequence.add(new Give(bandit, ring, player));
	sequence.add(new AddToList(ring));
	return sequence;
}

private ActionSequence getBanditRunsAwaySequence() {
	var sequence = new ActionSequence();
	sequence.add(new Create<Item>(rock));
	sequence.add(new AddToList(Rock));
	sequence.add(new Attack(player, bandit));
	sequence.add(new RemoveFromList(Rock));
	sequence.add(new Exit(bandit, SpookyPath.EastEnd));
	return sequence;
	
}
private ActionSequence getWitchRiddleSequence() {
	var sequence = new ActionSequence();
	sequence.combineWith(new CharacterCreation(witch));
	sequence.add(new Create<Place>(ruins));
	sequence.add(new Position(wtich, ruins));
	sequence.add(new Position(player, ruins));
	sequence.add(new SetDialog("I am witch I challenge you with riddle"));

	return sequence;
	
}
private ActionSequence getWitchDiesSequence() {
	var sequence = new ActionSequence();
	sequence.add(new SetDialog("Noooo I die now"));
	sequence.add(new Die(witch));
	
	return sequence;
}

private ActionSequence getYouDieSequence() {
	var sequence = new ActionSequence();
	sequence.add(new SetDialog("Wrong answer, i win, you die"));
	sequence.add(new Die(player));
}

private ActionSequence getReturnCourtyardSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Position(player, courtYard));
	return sequence;
}
private ActionSequence getKingdomCongratsSequence() {
	var sequence = new ActionSequence();
	sequence.combineWith(new CharacterCreation(king));
	sequence.add(new Position(Queen, greatHall));
	sequence.add(new Position(King, greatHall));
	sequence.add(new Position(player, greatHall));
	sequence.add(new SetDialog("Congrats for killing the witch, who do you want to talk to?"));
	return sequence;
}
private ActionSequence getQueenLoveSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Create<Place>(castleBedroom));
	sequence.add(new Position(Queen, castleBedroom));
	sequence.add(new Position(player, castleBedroom));
	sequence.add(new SetDialog("I always loved you"));
	return sequence;
}
private ActionSequence getHappilyEverAfterSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Give(player, ring, Queen));
	sequence.add(new RemoveFromList(Ring));
	sequence.add(new SetDialog("You won! Happily Ever After"));
	sequence.add(new FadeOut());
	return sequence;
}
private ActionSequence getQueenTellsYouLeaveSequence() {
	var sequence = new ActionSequence();
	sequence.add(new SetDialog("I don't love you, sorry"));
	sequence.add(new SetDialog("Okay, go to the king"));
	sequence.add(new Exit(player, castleBedroom.Door));
	sequence.add(new Position(king, greatHall));
	sequence.add(new Position(player, greatHall));
	sequence.add(new SetDialog("Will you show me your knight proof"));
	return sequence;
}
private ActionSequence getKingProofSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Position(king, greatHall));
	sequence.add(new Position(player, greatHall));
	sequence.add(new SetDialog("Will you show me your knight proof"));
	return sequence;
}
private ActionSequence getHeadKnightSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Give(player, openScroll, king));
	sequence.add(new RemoveFromList(OpenScroll));
	sequence.add(new SetDialog("You are a knight! I am promoting you to head knight"));
	sequence.add(new SetDialog("You got the second best option! Semi-Happily Ever After"));
	sequence.add(new FadeOut());
	return sequence;
}
private ActionSequence getDungeonSequence() {
	var sequence = new ActionSequence();
	sequence.add(new Give(player, scroll, king));
	sequence.add(new RemoveFromList(Scroll));
	sequence.add(new SetDialog("Imposter! Murderer! This is not you!"));
	sequence.add(new Exit(player, greatHall.BasementDoor));
	sequence.add(new Create<Place>(Dungeon));
	sequence.add(new Postion(player, Dungeon));
	sequence.add(new SetDialog("You got the worst option! Sadly Ever After"));
	sequence.add(new FadeOut());
	return sequence;
	
}
private ActionSequence getNowPeasantSequence() {
	var sequence = new ActionSequence();
	sequence.add(new SetDialog("I'm the first knight"));
	sequence.add(new SetDialog("No you're not, and it seems you don't have proof. We're taking your stuff but you can keep the gold from your journey."));
	sequence.add(new Create<Item>(coin));
	sequence.add(new Give(king, coin, player));
	sequence.add(new AddToList(Coin));
	sequence.add(new SetDialog("You got the second-worst option! Mediocrely Ever After"));
	sequence.add(new FadeOut());
	return sequence;
}

enum NodeLabels
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
    ArriveCouryard,
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
    NowPeasant
}

private ActionMap getMap() {
    var map = new ActionMap();

    map.add(NodeLabels.Init.ToString(), getInitSequence());
    map.add(NodeLabels.DyingKnightHelp.ToString(), getDyingKnightHelpSequence());
    map.add(NodeLabels.KnightDies.ToString(), getKnightDiesSequence());
    map.add(NodeLabels.OnPathWithItems.ToString(), getOnPathWithItemsSequence());
    map.add(NodeLabels.GreatHallQueen.ToString(), getGreatHallQueenSequence());
    map.add(NodeLabels.KnightSurvives.ToString(), getKnightSurvivesSequence());
    map.add(NodeLabels.ArriveCity.ToString(), getArriveCitySequence());
    map.add(NodeLabels.KnightTavern.ToString(), getKnightTavernSequence());
    map.add(NodeLabels.KnightGivesItems.ToString(), getKnightGivesItemsSequence());
    map.add(NodeLabels.ArriveCourtyard.ToString(), getArriveCourtyardSequence());
    map.add(NodeLabels.WitchQuest.ToString(), getWitchQuestSequence());
    map.add(NodeLabels.Knight2Proof.ToString(), getKnight2ProofSequence());
    map.add(NodeLabels.Knight2LetsYouGo.ToString(), getKnight2LetsYouGoSequence());
    map.add(NodeLabels.Knight2Escape.ToString(), getKnight2EscapeSequence());
    map.add(NodeLabels.Knight2Battle.ToString(), getKnight2BattleSequence());
    map.add(NodeLabels.ObtainProof2.ToString(), getObtainProof2Sequence());
    map.add(NodeLabels.SpookyPath.ToString(), getSpookyPathSequence());
    map.add(NodeLabels.BanditQuestions.ToString(), getBanditQuestionsSequence());
    map.add(NodeLabels.BanditLovePotion.ToString(), getBanditLovePotionSequence());
    map.add(NodeLabels.BanditRunsAway.ToString(), getBanditRunsAwaySequence());
    map.add(NodeLabels.BanditGivesRing.ToString(), getBanditGivesRingSequence());
    map.add(NodeLabels.WitchRiddle.ToString(), getWitchRiddleSequence());
    map.add(NodeLabels.WitchDies.ToString(), getWitchDiesSequence());
    map.add(NodeLabels.YouDie.ToString(), getYouDieSequence());
    map.add(NodeLabels.ReturnCourtyard.ToString(), getReturnCourtyardSequence());
    map.add(NodeLabels.KingdomCongrats.ToString(), getKingdomCongratsSequence());
    map.add(NodeLabels.QueenLove.ToString(), getQueenLoveSequence());
    map.add(NodeLabels.HappilyEverAfter.ToString(), getHappilyEverAfterSequence());
    map.add(NodeLabels.QueenTellsYouLeave.ToString(), getQueenTellsYouLeaveSequence());
    map.add(NodeLabels.KingProof.ToString(), getKingProofSequence());
    map.add(NodeLabels.HeadKnight.ToString(), getHeadKnightSequence());
    map.add(NodeLabels.Dungeon.ToString(), getDungeonSequence());
    map.add(NodeLabels.NowPeasant.ToString(), getNowPeasantSequence());

    return map;
}

}
