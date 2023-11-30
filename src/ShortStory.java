import com.actions.*;
import com.storygraph.*;

import com.entities.Character;
import com.entities.Place;
import com.entities.Things.ThingNames;
import com.playerInput.*;
import com.sequences.CharacterCreation;
import com.entities.Item;


public class ShortStory implements IStory {

    public Character Player, King, Elder, Knight, Witch, Peasant, Husband, Queen, QueenNaked, Executioner4, Executioner5;
    
    public Item OpenScroll;
    
    public Place Dungeon, Courtyard, CastleCrossroads, Ruins, Farm, AlchemyShop, City, ForestPath, Cottage, CastleBedroom, Blacksmith;

    public ShortStory() {
        getThings();
    }
    private enum ChoiceLabels{
    	TalkToKing, Accept, Reject, Leave, TalkToElder, Continue, WitchChoice, TalkToPeasant, HusbandChoice, CityChoice, ForestChoice, ReadScroll, ShekelChoice, CastleChoice, TalkToQueen, TalkToCottageQueen, TalkToCastleQueen, ExecutionChoice, TalkToKnight, CityChoice1, ForestChoice1, 
    }
    
    
    
    @Override
    public INode getRoot() {
    	var atBlacksmithNode = new Node(NodeLabels.AtBlacksmith.toString());
    	
    	var CastleQueenDialogNode = new Node(NodeLabels.CastleQueenDialog.toString());

    	var CottageQueenDialogNode = new Node(NodeLabels.CottageQueenDialog.toString());
    	
    	var atCottageNode = new Node(NodeLabels.AtCottage.toString());
    	atCottageNode.addChild(new ActionChoice(ChoiceLabels.TalkToCottageQueen.toString(),Queen,ActionChoice.Icons.talk, "Talk to the Queen",true),CottageQueenDialogNode);

    	var atCastleNode = new Node(NodeLabels.AtCastle.toString());
    	atCastleNode.addChild(new ActionChoice(ChoiceLabels.TalkToCastleQueen.toString(),Queen,ActionChoice.Icons.talk, "Talk to the Queen",true),CastleQueenDialogNode);

    	var ShekelChoiceNode = new Node(NodeLabels.ShekelChoice.toString());
    	ShekelChoiceNode.addChild(new PositionChoice(Player, ForestPath.getFurniture("EastEnd"),PositionChoice.Condition.arrived),atCottageNode);
    	
    	var ExecutionChoiceNode = new Node(NodeLabels.ExecutionChoice.toString());
    	ExecutionChoiceNode.addChild(new PositionChoice(Player, City.getFurniture("EastEnd"),PositionChoice.Condition.arrived),atBlacksmithNode);

    	var CastleChoiceNode = new Node(NodeLabels.CastleChoice.toString());
    	CastleChoiceNode.addChild(new PositionChoice(Player, ForestPath.getFurniture("EastEnd"),PositionChoice.Condition.arrived),atCastleNode);
    	
    	var KnightDialogNode = new Node(NodeLabels.KnightDialog.toString());
    	KnightDialogNode.addChild(new SelectionChoice(ChoiceLabels.ExecutionChoice.toString()),ExecutionChoiceNode);

    	var QueenDialogNode = new Node(NodeLabels.QueenDialog.toString());
    	QueenDialogNode.addChild(new SelectionChoice(ChoiceLabels.ShekelChoice.toString()),ShekelChoiceNode);
    	QueenDialogNode.addChild(new SelectionChoice(ChoiceLabels.CastleChoice.toString()),CastleChoiceNode);
    	
    	var atCityNode = new Node(NodeLabels.AtCity.toString());
    	atCityNode.addChild(new ActionChoice(ChoiceLabels.TalkToKnight.toString(),Knight,ActionChoice.Icons.talk, "Talk to the Knight",true),KnightDialogNode);

    	var atForestNode = new Node(NodeLabels.AtForest.toString());
    	atForestNode.addChild(new ActionChoice(ChoiceLabels.TalkToQueen.toString(),Queen,ActionChoice.Icons.talk, "Talk to the Queen",true),QueenDialogNode);
    	
    	var ForestChoiceNode = new Node(NodeLabels.ForestChoice.toString());
    	ForestChoiceNode.addChild(new ActionChoice(ChoiceLabels.Leave.toString(),AlchemyShop.getFurniture("Door"),ActionChoice.Icons.exit,"Leave the Shop",true),atForestNode);
    	
    	var CityChoiceNode = new Node(NodeLabels.CityChoice.toString());
    	CityChoiceNode.addChild(new ActionChoice(ChoiceLabels.Leave.toString(),AlchemyShop.getFurniture("Door"),ActionChoice.Icons.exit,"Leave the Shop",true),atCityNode);
    	
    	var WitchScrollDialogNode = new Node(NodeLabels.WitchScrollDialog.toString());
    	WitchScrollDialogNode.addChild(new SelectionChoice(ChoiceLabels.CityChoice.toString()),CityChoiceNode);
    	WitchScrollDialogNode.addChild(new SelectionChoice(ChoiceLabels.ForestChoice.toString()),ForestChoiceNode);
    	
    	var atRuinsNode = new Node(NodeLabels.AtRuins.toString());
    	atRuinsNode.addChild(new ActionChoice(ChoiceLabels.ReadScroll.toString(),OpenScroll,ActionChoice.Icons.research, "Read the scroll of the witch",true),WitchScrollDialogNode);

    	var ForestChoice1Node = new Node(NodeLabels.ForestChoice1.toString());
    	ForestChoice1Node.addChild(new PositionChoice(Player, Farm.getFurniture("Exit"),PositionChoice.Condition.arrived),atForestNode);
    	
    	var CityChoice1Node = new Node(NodeLabels.CityChoice1.toString());
    	CityChoice1Node.addChild(new PositionChoice(Player, Farm.getFurniture("Exit"),PositionChoice.Condition.arrived),atCityNode);
    	
    	var HusbandScrollDialogNode = new Node(NodeLabels.HusbandScrollDialog.toString());
    	HusbandScrollDialogNode.addChild(new SelectionChoice(ChoiceLabels.CityChoice1.toString()),CityChoice1Node);
    	HusbandScrollDialogNode.addChild(new SelectionChoice(ChoiceLabels.ForestChoice1.toString()),ForestChoice1Node);
    	
    	var atFarmNode = new Node(NodeLabels.AtFarm.toString());
    	atFarmNode.addChild(new ActionChoice(ChoiceLabels.ReadScroll.toString(),OpenScroll,ActionChoice.Icons.research, "Read the scroll of the husband",true),HusbandScrollDialogNode);
    	
    	var witchChoiceNode = new Node(NodeLabels.WitchChoice.toString());
    	witchChoiceNode.addChild(new PositionChoice(Player, CastleCrossroads.getFurniture("EastEnd"),PositionChoice.Condition.arrived),atRuinsNode);

    	var husbandChoiceNode = new Node(NodeLabels.HusbandChoice.toString());
    	husbandChoiceNode.addChild(new PositionChoice(Player, CastleCrossroads.getFurniture("EastEnd"),PositionChoice.Condition.arrived),atFarmNode);
    	
    	var PeasantDialogNode = new Node(NodeLabels.PeasantDialog.toString());
    	PeasantDialogNode.addChild(new SelectionChoice(ChoiceLabels.WitchChoice.toString()),witchChoiceNode);
    	PeasantDialogNode.addChild(new SelectionChoice(ChoiceLabels.HusbandChoice.toString()),husbandChoiceNode);

    	
    	var atCrossroadsNode = new Node(NodeLabels.AtCastleCrossroads.toString());
    	atCrossroadsNode.addChild(new ActionChoice(ChoiceLabels.TalkToPeasant.toString(),Peasant,ActionChoice.Icons.talk, "Talk to the Peasant",true),PeasantDialogNode);
    	
    	var continueNode =  new Node(NodeLabels.Continue.toString());
    	continueNode.addChild(new PositionChoice(Player, Courtyard.getFurniture("Exit"),PositionChoice.Condition.arrived),atCrossroadsNode);
    	
    	var elderDialogNode = new Node(NodeLabels.ElderDialog.toString());
    	elderDialogNode.addChild(new SelectionChoice(ChoiceLabels.Continue.toString()),continueNode);
    	
    	var atCourtyardNode = new Node(NodeLabels.AtCourtyard.toString());
    	atCourtyardNode.addChild(new ActionChoice(ChoiceLabels.TalkToElder.toString(),Elder,ActionChoice.Icons.talk, "Talk to the Elder",true),elderDialogNode);
    	
    	var acceptNode = new Node(NodeLabels.Accept.toString());
    	acceptNode.addChild(new ActionChoice(ChoiceLabels.Leave.toString(),Dungeon.getFurniture("Door"),ActionChoice.Icons.exit,"Leave the Dungeon",true),atCourtyardNode);
    	
    	var kingDialogNode = new Node(NodeLabels.KingDialog.toString());
    	kingDialogNode.addChild(new SelectionChoice(ChoiceLabels.Accept.toString()),acceptNode);
    	
    	var atDungeonNode = new Node(NodeLabels.AtDungeon.toString());
    	atDungeonNode.addChild(new ActionChoice(ChoiceLabels.TalkToKing.toString(),King,ActionChoice.Icons.talk, "Talk to the King",true),kingDialogNode);
    	
    	return atDungeonNode;
    }

    @Override
    public void getThings() {
    	 Dungeon = new Place(ThingNames.Dungeon.toString(), Place.Places.Dungeon);
    	 Courtyard = new Place(ThingNames.Courtyard.toString(), Place.Places.Courtyard);
    	 CastleCrossroads = new Place(ThingNames.CastleCrossroads.toString(), Place.Places.CastleCrossroads);
    	 Ruins = new Place(ThingNames.Ruins.toString(), Place.Places.Ruins);
    	 Farm = new Place(ThingNames.Farm.toString(), Place.Places.Farm);
    	 AlchemyShop = new Place(ThingNames.AlchemyShop.toString(), Place.Places.AlchemyShop);
    	 City = new Place(ThingNames.City.toString(), Place.Places.City);
    	 ForestPath = new Place(ThingNames.ForestPath.toString(), Place.Places.ForestPath);
    	 Cottage = new Place(ThingNames.Cottage.toString(), Place.Places.Cottage);
    	 CastleBedroom = new Place(ThingNames.CastleBedroom.toString(), Place.Places.CastleBedroom);
    	 Blacksmith = new Place(ThingNames.Blacksmith.toString(), Place.Places.Blacksmith);
    	 Player = new Character(ThingNames.Player.toString(), Character.BodyType.D, Character.Clothing.Bandit);
    	 King = new Character(ThingNames.King.toString(), Character.BodyType.F, Character.Clothing.King);
    	 Elder = new Character(ThingNames.Elder.toString(), Character.BodyType.F, Character.Clothing.Priest);
    	 Knight = new Character(ThingNames.Knight.toString(), Character.BodyType.F, Character.Clothing.HeavyArmour);
    	 Witch = new Character(ThingNames.Witch.toString(), Character.BodyType.G, Character.Clothing.Witch);
    	 Peasant = new Character(ThingNames.Peasant.toString(), Character.BodyType.C, Character.Clothing.Priest);
    	 Executioner4 = new Character(ThingNames.Executioner4.toString(), Character.BodyType.D, Character.Clothing.HeavyArmour);
    	 Executioner5 = new Character(ThingNames.Executioner5.toString(), Character.BodyType.D, Character.Clothing.HeavyArmour);
    	 Husband = new Character(ThingNames.Husband.toString(), Character.BodyType.H, Character.Clothing.Peasant);
    	 Queen = new Character(ThingNames.Queen.toString(), Character.BodyType.A, Character.Clothing.Queen);
    	 OpenScroll = new Item(ThingNames.OpenScroll.toString(), Item.Items.OpenScroll);
        }
    
    private ActionSequence getCastleQueenDialog() {
    	var sequence = new ActionSequence();
    	sequence.add(new SetDialog("The surprise is that I had the King killed for you to take his place... I never liked him anyway. This kingdom is now ours my savior. If you want to see what else could have happened play again. Good bye!"));
    	sequence.add(new SetLeft(Player));
    	sequence.add(new SetRight(Queen));
    	sequence.add(new ShowDialog());
    	sequence.add(new Wait(8));
    	sequence.add(new HideDialog());
    	sequence.add(new DanceTogether(Queen, Player));
    	sequence.add(new FadeOut());
    	return sequence;
    }
    
    private ActionSequence getCottageQueenDialog() {
    	var sequence = new ActionSequence();
    	sequence.add(new SetDialog("This is your new home. I hope you like it. I got it at a 7.82 percent interest rate so about market level. I have to go now but if you want to see what else could have happened please play again. Good bye!"));
    	sequence.add(new SetLeft(Player));
    	sequence.add(new SetRight(Queen));
    	sequence.add(new ShowDialog());
    	sequence.add(new Wait(8));
    	sequence.add(new ShowDialog());
    	sequence.add(new DanceTogether(Queen, Player));
    	sequence.add(new FadeOut());
    	return sequence;
    }
    
    private ActionSequence getAtCastle() {
    	var sequence = new ActionSequence();
    	sequence.add(new Create<Place>(CastleBedroom));
    	sequence.add(new EnableInput(false));
    	sequence.add(new Exit(Player, ForestPath.getFurniture("EastEnd"), true));
    	sequence.add(new Enter(Player, CastleBedroom.getFurniture("Door"), true));
    	sequence.combineWith(new CharacterCreation(Queen));
    	sequence.add(new Position(Queen, CastleBedroom, "Bed"));
    	sequence.add(new EnableInput(true));
    	return sequence;
    }
    
    private ActionSequence getCastleChoice() {
    	var sequence = new ActionSequence();
    	sequence.add(new HideDialog());
    	
    	return sequence;
    }
   
    private ActionSequence getAtBlacksmith() {
    	var sequence = new ActionSequence();
    	sequence.add(new Create<Place>(Blacksmith));
    	sequence.add(new EnableInput(false));
    	sequence.add(new Exit(Player, City.getFurniture("EastEnd"), true));
    	sequence.add(new Enter(Player, Blacksmith.getFurniture("Door"), true));
    	sequence.combineWith(new CharacterCreation(Executioner4));
    	sequence.combineWith(new CharacterCreation(Executioner5));
    	sequence.add(new Position(Executioner4, Blacksmith, "Anvil"));
    	sequence.add(new Position(Executioner5, Blacksmith, "Chest"));
    	sequence.add(new Dance(Executioner4));
    	sequence.add(new Dance(Executioner5));
    	sequence.add(new EnableInput(true));
    	sequence.add(new Die(Player));
    	sequence.add(new Wait(3));
    	sequence.add(new FadeOut());
    	return sequence;
    }
    
    private ActionSequence getAtCottage() {
    	var sequence = new ActionSequence();
    	sequence.add(new Create<Place>(Cottage));
    	sequence.add(new EnableInput(false));
    	sequence.add(new Exit(Player, ForestPath.getFurniture("EastEnd"), true));
    	sequence.add(new Enter(Player, Cottage.getFurniture("Door"), true));
    	sequence.combineWith(new CharacterCreation(Queen));
    	sequence.add(new Position(Queen, Cottage, "Bed"));
    	sequence.add(new EnableInput(true));
    	return sequence;
    }
    
    private ActionSequence getExecutionChoice() {
    	var sequence = new ActionSequence();
    	sequence.add(new HideDialog());
    	sequence.add(new Laugh(Knight));
    	return sequence;
    }
    
    private ActionSequence getShekelChoice() {
    	var sequence = new ActionSequence();
    	sequence.add(new HideDialog());
    	return sequence;
    }
    
    private ActionSequence getKnightDialog() {
    	var sequence = new ActionSequence();
    	sequence.add(new SetDialog("You lost. You did not find the queen so you will be executed. The King gave you one task and you could not even complete that. Go through the fog to meet your fate."));
    	sequence.add(new SetDialog("[ExecutionChoice| Continue to your fate]"));
    	sequence.add(new SetLeft(Player));
    	sequence.add(new SetRight(Knight));
    	sequence.add(new ShowDialog());
    	return sequence;
    }
    
    private ActionSequence getQueenDialog() {
    	var sequence = new ActionSequence();
    	sequence.add(new SetDialog("You win. You have 2 options. Do you want a gazillion shekels or a special surprise back at the castle. The shekels can get you a down payment on a house but who knows what the prize is in the castle. Go back through the fog once you have decided."));
    	sequence.add(new SetDialog("[ShekelChoice| Get a gazillion shekels]"));
    	sequence.add(new SetDialog("[CastleChoice| Go to the Castle with the Queen]"));
    	sequence.add(new SetLeft(Player));
    	sequence.add(new SetRight(Queen));
    	sequence.add(new ShowDialog());
    	return sequence;
    }
    
    private ActionSequence getAtForest1() {
    	var sequence = new ActionSequence();
    	sequence.add(new Create<Place>(ForestPath));
    	sequence.add(new EnableInput(false));
    	sequence.add(new Exit(Player, Farm.getFurniture("Exit"), true));
    	sequence.add(new Enter(Player, ForestPath.getFurniture("EastEnd"), true));
    	sequence.combineWith(new CharacterCreation(Queen));
    	sequence.add(new Position(Queen, ForestPath, "DirtPile"));
    	sequence.add(new EnableInput(true));
    	return sequence;
    }
    
    private ActionSequence getForestChoice1() {
    	var sequence = new ActionSequence();
    	sequence.add(new HideDialog());
    	
    	return sequence;
    }
    
    private ActionSequence getAtCity1() {
    	var sequence = new ActionSequence();
    	sequence.add(new Create<Place>(City));
    	sequence.add(new EnableInput(false));
    	sequence.add(new Exit(Player, Farm.getFurniture("Exit"), true));
    	sequence.add(new Enter(Player, City.getFurniture("NorthEnd"), true));
    	sequence.combineWith(new CharacterCreation(Knight));
    	sequence.add(new Position(Knight, City, "Fountain"));
    	sequence.add(new Face(Knight, Player));
    	sequence.add(new EnableInput(true));
    	return sequence;
    }
    
    private ActionSequence getCityChoice1() {
    	var sequence = new ActionSequence();
    	sequence.add(new HideDialog());
    	
    	return sequence;
    }
    
    private ActionSequence getAtForest() {
    	var sequence = new ActionSequence();
    	sequence.add(new Create<Place>(ForestPath));
    	sequence.add(new EnableInput(false));
    	sequence.add(new Exit(Player, AlchemyShop.getFurniture("Door"), true));
    	sequence.add(new Enter(Player, ForestPath.getFurniture("EastEnd"), true));
    	sequence.combineWith(new CharacterCreation(Queen));
    	sequence.add(new Position(Queen, ForestPath, "DirtPile"));
    	sequence.add(new EnableInput(true));
    	return sequence;
    }
    
    private ActionSequence getForestChoice() {
    	var sequence = new ActionSequence();
    	sequence.add(new HideDialog());
    	
    	return sequence;
    }
    
    private ActionSequence getAtCity() {
    	var sequence = new ActionSequence();
    	sequence.add(new Create<Place>(City));
    	sequence.add(new EnableInput(false));
    	sequence.add(new Exit(Player, AlchemyShop.getFurniture("Door"), true));
    	sequence.add(new Enter(Player, City.getFurniture("NorthEnd"), true));
    	sequence.combineWith(new CharacterCreation(Knight));
    	sequence.add(new Position(Knight, City, "Fountain"));
    	sequence.add(new Face(Knight, Player));
    	sequence.add(new EnableInput(true));
    	return sequence;
    }
    
    private ActionSequence getCityChoice() {
    	var sequence = new ActionSequence();
    	sequence.add(new HideDialog());
    	
    	return sequence;
    }
    
    private ActionSequence getHusbandScrollDialog() {
    	var sequence = new ActionSequence();
    	sequence.add(new SetDialog("I think I might have seen a Queen looking person go in the direction of the city. But there were also a set of footsteps that might be the Queens heading for the forest. Im not totally sure but choose carefully. Go Back through the fog once you have decided."));
    	sequence.add(new SetDialog("[CityChoice1| Go to the City]"));
    	sequence.add(new SetDialog("[ForestChoice1| Go to the Forest]"));
    	sequence.add(new SetLeft(Player));
    	sequence.add(new SetRight(Husband));
    	sequence.add(new ShowDialog());
    	return sequence;
    }
    
    private ActionSequence getWitchScrollDialog() {
    	var sequence = new ActionSequence();
    	sequence.add(new SetDialog("The Queen left me a clue... She told me she would meet where I am most comfortable. Remember what you have read and choose where you think the Queen is. Choose wisely. Leave through the door once you have decided."));
    	sequence.add(new SetDialog("[CityChoice| Go to the City]"));
    	sequence.add(new SetDialog("[ForestChoice| Go to the Forest]"));
    	sequence.add(new SetLeft(Player));
    	sequence.add(new SetRight(Witch));
    	sequence.add(new ShowDialog());
    	return sequence;
    }
    
    private ActionSequence getAtFarm() {
    	var sequence = new ActionSequence();
    	sequence.add(new Create<Place>(Farm));
    	sequence.add(new EnableInput(false));
    	sequence.add(new Exit(Player, CastleCrossroads.getFurniture("EastEnd"), true));
    	sequence.add(new Enter(Player, Farm.getFurniture("Exit"), true));
    	sequence.combineWith(new CharacterCreation(Husband));
    	sequence.add(new Position(Husband, Farm, "Anvil"));
    	sequence.add(new Face(Husband, Player));
    	sequence.add(new Create<Item>(OpenScroll));
    	sequence.add(new Position(OpenScroll, Farm, "Anvil"));
    	sequence.add(new EnableInput(true));
    	return sequence;
    }
    
    private ActionSequence getHusbandChoice() {
    	var sequence = new ActionSequence();
    	sequence.add(new HideDialog());
    	
    	return sequence;
    }
    
    private ActionSequence getAtRuins() {
    	var sequence = new ActionSequence();
    	sequence.add(new Create<Place>(AlchemyShop));
    	sequence.add(new EnableInput(false));
    	sequence.add(new Exit(Player, CastleCrossroads.getFurniture("EastEnd"), true));
    	sequence.add(new Enter(Player, AlchemyShop.getFurniture("Door"), true));
    	sequence.combineWith(new CharacterCreation(Witch));
    	sequence.add(new Position(Witch, AlchemyShop, "Table"));
    	sequence.add(new Face(Witch, Player));
    	sequence.add(new Create<Item>(OpenScroll));
    	sequence.add(new Position(OpenScroll, AlchemyShop, "Table"));
    	sequence.add(new EnableInput(true));
    	return sequence;
    }
    
    private ActionSequence getWitchChoice() {
    	var sequence = new ActionSequence();
    	sequence.add(new HideDialog());
    	
    	return sequence;
    }
    
    private ActionSequence getPeasantDialog() {
    	var sequence = new ActionSequence();
    	sequence.add(new SetDialog("You have 2 options. You can go meet with a retired witch. She was a druid of the forest and claims to have a scroll for you. Or you can go get the scroll that my husband has. He is an excellent tracker of the spooky forests but needs glasses. Follow the fog."));
    	sequence.add(new SetDialog("[WitchChoice| Witch Path]"));
    	sequence.add(new SetDialog("[HusbandChoice| Husband Path]"));
    	sequence.add(new SetLeft(Player));
    	sequence.add(new SetRight(Peasant));
    	sequence.add(new ShowDialog());
    	return sequence;
    }
    
    private ActionSequence getAtCastleCrossroads() {
    	var sequence = new ActionSequence();
    	sequence.add(new Create<Place>(CastleCrossroads));
    	sequence.add(new EnableInput(false));
    	sequence.add(new Exit(Player, Courtyard.getFurniture("Exit"), true));
    	sequence.add(new Enter(Player, CastleCrossroads.getFurniture("Gate"), true));
    	sequence.combineWith(new CharacterCreation(Peasant));
    	sequence.add(new Position(Peasant, CastleCrossroads, "EastEnd"));
    	sequence.add(new Face(Peasant, Player));
    	sequence.add(new EnableInput(true));
    	return sequence;
    }
    
    private ActionSequence getContinue() {
    	var sequence = new ActionSequence();
    	sequence.add(new HideDialog());
    	return sequence;
    }
    
    private ActionSequence getElderDialog() {
    	var sequence = new ActionSequence();
    	sequence.add(new SetDialog("The Queen left with a peasant and went into the forest. Be careful who you trust. The only thing I can tell you is that they went through the fog and to the right."));
    	sequence.add(new SetDialog("[Continue| Onwards]"));
    	sequence.add(new SetLeft(Player));
    	sequence.add(new SetRight(Elder));
    	sequence.add(new ShowDialog());
    	return sequence;
    }
    
    private ActionSequence getAtCourtyard() {
    	var sequence = new ActionSequence();
    	sequence.add(new EnableInput(false));
    	sequence.add(new Exit(Player, Dungeon.getFurniture("Door"), true));
    	sequence.add(new Enter(Player, Courtyard.getFurniture("Gate"), true));
    	sequence.combineWith(new CharacterCreation(Elder));
    	sequence.add(new Position(Elder, Courtyard, "Horse"));
    	sequence.add(new Face(Elder, Player));
    	sequence.add(new EnableInput(true));
    	return sequence;
    }
    
    private ActionSequence getAccept() {
    	var sequence = new ActionSequence();
    	sequence.add(new HideDialog());
    	return sequence;
    }
    
    private ActionSequence getKingDialog() {
    	var sequence = new ActionSequence();
    	sequence.add(new SetDialog("My Queen has run away and wants someone to find her! She left behind a series of clues but said that only someone who is worthy can find her. If we fail she will hide forever. I am assigning you to this mission because you used to be her friend. There is an elder outside who has intel. Everything you hear matters. Good luck."));
    	sequence.add(new SetDialog("[Accept| Accept the Mission]"));
    	sequence.add(new SetLeft(Player));
    	sequence.add(new SetRight(King));
    	sequence.add(new ShowDialog());
    	return sequence;
    }
    
    private ActionSequence getAtDungeon() {
    	var sequence = new ActionSequence();
    	sequence.combineWith(new CharacterCreation(Player));
    	sequence.combineWith(new CharacterCreation(King));
    	sequence.add(new Create<Place>(Dungeon));
    	sequence.add(new Create<Place>(Courtyard));
    	sequence.add(new Position(King, Dungeon, "Chair"));
    	sequence.add(new Position(Player, Dungeon));
    	sequence.add(new Face(King, Player));
    	sequence.add(new SetCameraFocus(Player));
    	sequence.add(new ShowMenu(true));
    	sequence.add(new ShowMenu(false));
    	sequence.add(new EnableInput(true));
    	return sequence;
    }

private enum NodeLabels
{
    AtDungeon, KingDialog, Accept, AtCourtyard, ElderDialog, AtCastleCrossroads, Continue, WitchChoice, PeasantDialog, AtRuins, HusbandChoice, AtFarm, CityChoice, ForestChoice, AtForest, AtCity, WitchScrollDialog, QueenDialog, ShekelChoice, CastleChoice, AtCastle, AtCottage, CottageQueenDialog, CastleQueenDialog, KnightDialog, ExecutionChoice, AtBlacksmith, HusbandScrollDialog, CityChoice1, ForestChoice1, AtForest1, AtCity1;
}

@Override
public ActionMap getMap() {
    var map = new ActionMap();
    map.add(NodeLabels.AtDungeon.toString(), getAtDungeon());
    map.add(NodeLabels.KingDialog.toString(), getKingDialog());
    map.add(NodeLabels.Accept.toString(), getAccept());
    map.add(NodeLabels.AtCourtyard.toString(), getAtCourtyard());
    map.add(NodeLabels.ElderDialog.toString(), getElderDialog());
    map.add(NodeLabels.AtCastleCrossroads.toString(), getAtCastleCrossroads());
    map.add(NodeLabels.Continue.toString(), getContinue());
    map.add(NodeLabels.PeasantDialog.toString(), getPeasantDialog());
    map.add(NodeLabels.WitchChoice.toString(), getWitchChoice());
    map.add(NodeLabels.AtRuins.toString(), getAtRuins());
    map.add(NodeLabels.HusbandChoice.toString(), getHusbandChoice());
    map.add(NodeLabels.AtFarm.toString(), getAtFarm());
    map.add(NodeLabels.CityChoice.toString(), getCityChoice());
    map.add(NodeLabels.ForestChoice.toString(), getForestChoice());
    map.add(NodeLabels.AtForest.toString(), getAtForest());
    map.add(NodeLabels.AtCity.toString(), getAtCity());
    map.add(NodeLabels.WitchScrollDialog.toString(), getWitchScrollDialog());
    map.add(NodeLabels.QueenDialog.toString(), getQueenDialog());
    map.add(NodeLabels.ShekelChoice.toString(), getShekelChoice());
    map.add(NodeLabels.CastleChoice.toString(), getCastleChoice());
    map.add(NodeLabels.AtCastle.toString(), getAtCastle());
    map.add(NodeLabels.AtCottage.toString(), getAtCottage());
    map.add(NodeLabels.CottageQueenDialog.toString(), getCottageQueenDialog());
    map.add(NodeLabels.CastleQueenDialog.toString(), getCastleQueenDialog());
    map.add(NodeLabels.KnightDialog.toString(), getKnightDialog());
    map.add(NodeLabels.ExecutionChoice.toString(), getExecutionChoice());
    map.add(NodeLabels.AtBlacksmith.toString(), getAtBlacksmith());
    map.add(NodeLabels.HusbandScrollDialog.toString(), getHusbandScrollDialog());
    map.add(NodeLabels.CityChoice1.toString(), getCityChoice1());
    map.add(NodeLabels.ForestChoice1.toString(), getForestChoice1());
    map.add(NodeLabels.AtForest1.toString(), getAtForest1());
    map.add(NodeLabels.AtCity1.toString(), getAtCity1());

    return map;
	}
}