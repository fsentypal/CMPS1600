import com.storygraph.*;

import java.util.ArrayList;
import java.util.Optional;

import com.actions.ActionSequence;
import com.entities.Character;
import com.entities.Place;
import com.entities.Things.ThingNames;
import com.playerInput.IPlayerChoice;
import com.entities.Item;


// ShortStory class that implements IStory
public class ShortStory implements IStory {
	public interface IStory {
	    ActionMap getMap();
	    INode getRoot();
	    void getThings();
	}

    // Declaring characters
    public Character knight1, knight2, queen, king, witch, bandit;
    
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
	
}

private ActionSequence getStarSequence() {
	
}
private ActionSequence getSpawnFarmSequence() {
	
}
private ActionSequence getDyingKnightHelpSequence() {
	
}
private ActionSequence getKnightDiesSequence() {
	
}
private ActionSequence getOnPathWithItemsSequence() {
	
}
private ActionSequence getGreatHallQueenSequence() {
	
}
private ActionSequence getKnightSurvivesSequence() {
	
}
private ActionSequence getArriveCitySequence() {
	
}
private ActionSequence getKnightTavernSequence() {
	
}
private ActionSequence getKnightGivesItemsSequence() {
	
}
private ActionSequence getArriveCourtardSequence() {
	
}
private ActionSequence getWitchQuestSequence() {
	
}
private ActionSequence getKnight2ProofSequence() {
	
}
private ActionSequence getKnight2LetsYouGoSequence() {
	
}
private ActionSequence getKnight2EscapeSequence() {
	
}
private ActionSequence getKnight2BattleSequence() {
	
}
private ActionSequence getObtainProof2Sequence() {
	
}
private ActionSequence getSpookyPathSequence() {
	
}
private ActionSequence getBanditQuestionsSequence() {
	
}
private ActionSequence getBanditLovePotionSequence() {
	
}
private ActionSequence getBanditRunsAwaySequence() {
	
}
private ActionSequence getBanditGivesRingSequence() {
	
}
private ActionSequence getWitchRiddleSequence() {
	
}
private ActionSequence getWitchDiesSequence() {
	
}
private ActionSequence getReturnCourtyardSequence() {
	
}
private ActionSequence getKingdomCongratsSequence() {
	
}
private ActionSequence getQueenLoveSequence() {
	
}
private ActionSequence getHappilyEverAfterSequence() {
	
}
private ActionSequence getQueenTellsYouLeaveSequence() {
	
}
private ActionSequence getKingProofSequence() {
	
}
private ActionSequence getHeadKnightSequence() {
	
}
private ActionSequence getDungeonSequence() {
	
}
private ActionSequence getNowPeasantSequence() {
	
}
}
