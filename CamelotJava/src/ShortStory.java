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
    public ActionMap getMap() {
        return null; // Placeholder
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
	sequence.add (new Position(player, farm));
	sequence.add(new Create<Item>(bread));
	sequence.add(new Position(bread, farm, "Shelf"));
	sequence.add(new SetCameraFocus(player));
	sequence.add(new ShowMenu(true));
	sequence.add(new EnableInput(true));
	return sequence;
}
private ActionSequence getDyingKnightHelpSequence() {
	var sequence = new ActionSequence();
	sequence.combineWith(new CharacterCreation(kinght));
	sequence.add(new Create<Place>(forestPath));
	sequence.add(new Position(knight, forestPath));
	sequence.add(new Position(player, forestPath));
	sequence.add(new Create<Item>(sword));
	sequence.add(new SetDialog("Help! I don't have much life left in me, please spare me that bread you have..."));
	sequence.add(new );
	
}
private ActionSequence getKnightDiesSequence() {
	var sequence = new ActionSequence();
}
private ActionSequence getOnPathWithItemsSequence() {
	var sequence = new ActionSequence();
}
private ActionSequence getGreatHallQueenSequence() {
	var sequence = new ActionSequence();
}
private ActionSequence getKnightSurvivesSequence() {
	var sequence = new ActionSequence();
}
private ActionSequence getArriveCitySequence() {
	var sequence = new ActionSequence();
}
private ActionSequence getKnightTavernSequence() {
	var sequence = new ActionSequence();
}
private ActionSequence getKnightGivesItemsSequence() {
	var sequence = new ActionSequence();
}
private ActionSequence getArriveCourtardSequence() {
	var sequence = new ActionSequence();
}
private ActionSequence getWitchQuestSequence() {
	var sequence = new ActionSequence();
}
private ActionSequence getKnight2ProofSequence() {
	var sequence = new ActionSequence();
}
private ActionSequence getKnight2LetsYouGoSequence() {
	var sequence = new ActionSequence();
}
private ActionSequence getKnight2EscapeSequence() {
	var sequence = new ActionSequence();
}
private ActionSequence getKnight2BattleSequence() {
	var sequence = new ActionSequence();
}
private ActionSequence getObtainProof2Sequence() {
	var sequence = new ActionSequence();
}
private ActionSequence getSpookyPathSequence() {
	var sequence = new ActionSequence();
}
private ActionSequence getBanditQuestionsSequence() {
	var sequence = new ActionSequence();
}
private ActionSequence getBanditLovePotionSequence() {
	var sequence = new ActionSequence();
}
private ActionSequence getBanditRunsAwaySequence() {
	var sequence = new ActionSequence();
}
private ActionSequence getBanditGivesRingSequence() {
	var sequence = new ActionSequence();
}
private ActionSequence getWitchRiddleSequence() {
	var sequence = new ActionSequence();
}
private ActionSequence getWitchDiesSequence() {
	var sequence = new ActionSequence();
}
private ActionSequence getReturnCourtyardSequence() {
	var sequence = new ActionSequence();
}
private ActionSequence getKingdomCongratsSequence() {
	var sequence = new ActionSequence();
}
private ActionSequence getQueenLoveSequence() {
	var sequence = new ActionSequence();
}
private ActionSequence getHappilyEverAfterSequence() {
	var sequence = new ActionSequence();
}
private ActionSequence getQueenTellsYouLeaveSequence() {
	var sequence = new ActionSequence();
}
private ActionSequence getKingProofSequence() {
	var sequence = new ActionSequence();
}
private ActionSequence getHeadKnightSequence() {
	var sequence = new ActionSequence();
}
private ActionSequence getDungeonSequence() {
	var sequence = new ActionSequence();
}
private ActionSequence getNowPeasantSequence() {
	var sequence = new ActionSequence();
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
    ArriveCourtard,
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
    map.add(NodeLabels.ArriveCourtard.ToString(), getArriveCourtardSequence());
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
