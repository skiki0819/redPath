package com.example.redpath;


import static java.lang.String.valueOf;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.PersistableBundle;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Story extends AppCompatActivity {
GameScreen gs;
String nextPosition1, nextPosition2, nextPosition3;
boolean fullHeal=false;
boolean crossbow=false;
boolean cloth=false;
boolean peckes=false;
boolean sword=false;
boolean wand=false;
boolean daughter=true;
boolean acceloOn=false;
boolean sneaking=false;
boolean roaring=false;
boolean beatGozor=false;
boolean beatRagnar=false;
int gold =0;

    public Story (GameScreen gs){

    this.gs = gs;
}

    private void allButtonVisible(){
        gs.b1.setVisibility(View.VISIBLE);
        gs.b2.setVisibility(View.VISIBLE);
        gs.b3.setVisibility(View.VISIBLE);
    }

    public void selectPosition(String position){

        switch (position){
            case "startingPoint" : startingPoint(); break;
            case "healersHouse" : hHouse(); break;
            case "searchForSurvivors" : sfSurvivors(); break;
            case "nextVillage" : nVillage(); break;
            case "cave" : cave(); break;
            case "stable" : stable(); break;
            case "healerHouseUpstairs" : healerHouseUpstairs(); break;
            case "foundPotionInCave" : foundPotionInCave(); break;
            case "killedByTroll" : killedByTroll(); break;
            case "killedByTrollCoward" : killedByTrollCoward(); break;
            case "goDeeperIntoCave" : goDeeperIntoCave(); break;
            case "reachTheCrossroads" : reachTheCrossroads(); break;
            case "reachTheBridge" : reachTheBridge(); break;
            case "foundTheCrossbow" : foundTheCrossbow(); break;
            case "crossTheBridge" : crossTheBridge(); break;
            case "continueFollowTheRiver" : continueFollowTheRiver(); break;
            case "beatTheDwarf" : beatTheDwarf(); break;
            case "escapeFromDwarf" : escapeFromDwarf(); break;
            case "successEscapeFromDwarf" : successEscapeFromDwarf(); break;
            case "dieInDwarfsHut" : dieInDwarfsHut(); break;
            case "islandChecked" : islandChecked(); break;
            case "useMindTrick" : useMindTrick(); break;
            case "deadWithSpoon" : deadWithSpoon(); break;
            case "dwarfsBeated" : dwarfsBeated(); break;
            case "sign" : sign(); break;
            case "merchant" : merchant(); break;
            case "begForFood" : begForFood(); break;
            case "killTheMerchant" : killTheMerchant(); break;
            case "getTheSword" : getTheSword(); break;
            case "gozor" : gozor(); break;
            case "ragnar" : ragnar(); break;
            case "witch" : witch(); break;
            case "sneak" : sneak(); break;
            case "roaring" : roaring(); break;
            case "witchBeaten" : witchBeaten(); break;
            case "crossroadsWithWand" : crossroadsWithWand(); break;
            case "turnbackFromGozorWithWand" : turnbackFromGozorWithWand(); break;
            case "turnbackFromGozor" : turnbackFromGozor(); break;
            case "gozorBeaten" : gozorBeaten(); break;
            case "setTrap" : setTrap(); break;
            case "ragnarFight" : ragnarFight(); break;
            case "avoidAttack" : avoidAttack(); break;
            case "jumpHisHand" : jumpHisHand(); break;
            case "ending" : ending(); break;
        }

}

    private void gozorBeaten() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.gozor1);
        beatGozor=false;
        allButtonVisible();
        gs.storyText.setText("You successfully set the trap. You had to wait a several minutes for the dragon to arrive." +
                "You use yourself as bait to lead te dragon to the trap. Gozor do not hesitate, attacks you as she notice you." +
                "She attacks, you dodge it, Gozor fly into trap and she freeze to death. You made it. The world is a better place" +
                "without Gozor, but nobody will celebrate your victory. Now you have to continue the search after your daughter.");

        gs.b1.setText("Go back to the crossroads");
        gs.b2.setVisibility(View.INVISIBLE);
        gs.b3.setVisibility(View.INVISIBLE);

        nextPosition1 = "turnbackFromGozorWithWand";
    }

    private void ending() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.ending);
        daughter= true;
        gs.storyText.setText("Ragnar's terror is over! You set the slaves free, then you walk out of the temple with your " +
                "daughter in your hands. It's time to a better future! YOU ARE THE GREATEST HERO IN THE WORLD!\n\n See you next time!" +
                "\n\n Made by:\n MARCELL NEMES \n          AND\n KRISZTAN SANDOR");

        gs.b1.setVisibility(View.INVISIBLE);
        gs.b2.setVisibility(View.INVISIBLE);
        gs.b3.setVisibility(View.INVISIBLE);
    }

    private void jumpHisHand() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.ragnar);
        allButtonVisible();
        gs.storyText.setText("You are on his hand, you think you are one step ahead of him, but you didn't expect " +
                "that he can freeze you with his breath. You are dead.");

        gs.b1.setText("return to the checkpoint");
        gs.b2.setVisibility(View.INVISIBLE);
        gs.b3.setVisibility(View.INVISIBLE);

        nextPosition1 = "sign";
    }

    private void avoidAttack() {
        gs.sv.scrollTo(0,0);
        beatRagnar=true;
        gs.img.setImageResource(R.drawable.ragnar);

        if(!wand){
            gs.storyText.setText("You successfully avoid his fist, now it's your time to counter attack. You are trying cast the " +
                    "dragon breath spell with your wand. Oops, you don't have wand. You are dead!");

            gs.b1.setText("return to the checkpoint");
            gs.b2.setVisibility(View.INVISIBLE);
            gs.b3.setVisibility(View.INVISIBLE);

            nextPosition1 = "sign";
        }

        else{
            gs.storyText.setText("You successfully avoid his fist, now it's your time to counter attack. You are trying cast the " +
                    "dragon breath spell with your wand. You target it his eyes. Heat the wand! (30C°)");

            gs.b1.setVisibility(View.INVISIBLE);
            gs.b2.setVisibility(View.INVISIBLE);
            gs.b3.setVisibility(View.INVISIBLE);
        }
    }

    private void ragnarFight() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.ragnar);
        allButtonVisible();
        gs.storyText.setText("You step inside the temple. It's an enormous hall. At the end of the hall, there is a huge" +
                "throne, Ragnar's place. In front of the throne, there are a lot of human sized slave and you notice your daughter" +
                "is one of them. You charge forward and try to catch your daughter, but you can't reach her, because Ragnar stops" +
                " you with his hands. What will you do next?");

        gs.b1.setText("Try to avoid the next attack");
        gs.b2.setText("Try to jump up his hand");
        gs.b3.setVisibility(View.INVISIBLE);

            nextPosition1 = "avoidAttack";
            nextPosition2 = "jumpHisHand";
    }

    private void setTrap() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.gozor1);
        beatGozor=true;
        allButtonVisible();
        gs.storyText.setText("Using the wand you set a magical ice trap. Get colder the temperature! (5C°)");

        gs.b1.setVisibility(View.INVISIBLE);
        gs.b2.setVisibility(View.INVISIBLE);
        gs.b3.setVisibility(View.INVISIBLE);

        if (!wand){
            gs.storyText.setText("You're unarmed, the Gozor beat you easily.");
            gs.b2.setVisibility(View.VISIBLE);
            gs.b2.setText("return to the checkpoint");
            nextPosition2 = "reachTheCrossroads";
        }
    } //sensor

    private void turnbackFromGozorWithWand() {
        gs.sv.scrollTo(0,0);
        allButtonVisible();
        gs.img.setImageResource(R.drawable.daughter);
        gs.storyText.setText("One path left. Go and save your daughter!");

        gs.b1.setText("Turn right to Ragnar, the ice giant");
        gs.b2.setVisibility(View.INVISIBLE);
        gs.b3.setVisibility(View.INVISIBLE);

        nextPosition1 = "ragnar";
    }

    private void turnbackFromGozor() {
        gs.sv.scrollTo(0,0);
        allButtonVisible();
        gs.img.setImageResource(R.drawable.sign);
        gs.storyText.setText("You step closer to the sign." +
                " It says:\nTurn left if you want to reach Gozor, the fire dragon\n" +
                "Turn right if you want to reach Ragnar, the ice giant\n" +
                "Go ahead if you want to reach the witch\n  What will you do next?");

        gs.b1.setVisibility(View.INVISIBLE);
        gs.b2.setText("Turn right");
        gs.b3.setText("Go ahead");

        nextPosition2 = "ragnar";
        nextPosition3 = "witch";
    }

    private void crossroadsWithWand() {
        gs.sv.scrollTo(0,0);
        allButtonVisible();
        gs.img.setImageResource(R.drawable.sign);
        gs.storyText.setText("Which path do you choice?");

        gs.b1.setText("Turn left to Gozor, the fire dragon");
        gs.b2.setText("Turn right to Ragnar, the ice giant");
        gs.b3.setVisibility(View.INVISIBLE);

        nextPosition1 = "gozor";
        nextPosition2 = "ragnar";
    }

    private void witchBeaten() {
        gs.sv.scrollTo(0,0);
        allButtonVisible();
        gs.img.setImageResource(R.drawable.wand);
        gs.storyText.setText("You got the wand! Now you ready to face your fate.");

        gs.b1.setText("Back to the crossroads");
        gs.b2.setVisibility(View.INVISIBLE);
        gs.b3.setVisibility(View.INVISIBLE);

        nextPosition1 = "crossroadsWithWand";
    }

    private void roaring() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.witch);
        roaring=true;
        allButtonVisible();
        gs.storyText.setText("You charge at her roaring, try to being lauder.");

        gs.b1.setVisibility(View.INVISIBLE);
        gs.b2.setVisibility(View.INVISIBLE);
        gs.b3.setVisibility(View.INVISIBLE);

        if (!sword && !crossbow ){
            gs.storyText.setText("You're unarmed, the witch beats you easily.");
            gs.count =0;
            gs.b2.setVisibility(View.VISIBLE);
            gs.b2.setText("return to the checkpoint");
            nextPosition2 = "reachTheCrossroads";
        }
    }

    private void sneak() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.witch);
        sneaking = true;
        allButtonVisible();
        gs.storyText.setText("You trying to sneak behind the witch. Be quiet!");

        gs.b1.setVisibility(View.INVISIBLE);
        gs.b2.setVisibility(View.INVISIBLE);
        gs.b3.setVisibility(View.INVISIBLE);

        if (!sword && !crossbow ){
            gs.storyText.setText("You're unarmed, the witch beats you easily.");
            gs.count =0;
            gs.b2.setVisibility(View.VISIBLE);
            gs.b2.setText("return to the checkpoint");
            nextPosition2 = "reachTheCrossroads";
        }
    }

    private void witch() {
        gs.sv.scrollTo(0,0);
        allButtonVisible();
        gs.img.setImageResource(R.drawable.witch);
        gs.storyText.setText("During on the road, a big old oak appears in the distance. When you get closer you notice " +
                "the witch. She is cooking something in her pot and she looks very busy. You can see her magic wand" +
                "on her belt. You feel like you need this wand! What will you do?");

        gs.b1.setText("Sneak behind the witch");
        gs.b2.setText("Charge at her roaring");
        gs.b3.setVisibility(View.INVISIBLE);

        nextPosition1 = "sneak";
        nextPosition2 = "roaring";
    }

    private void ragnar() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.icecastle);
        allButtonVisible();
        gs.storyText.setText("You feel the cold wind on your face. You reach the edge of the land of endless winter." +
                "You feel the daughter is near. There are lot of building, built from ice. This is the place where Ragnar's bandits are" +
                "hiding. You checked most of the buildings and killed some bandits, but you couldn't find your daughter." +
                "She has to be in Ragnar's temple. You are nervous, because that means you have to face Ragnar. What will you do next?");

        gs.b1.setText("There is no way back, you have to save your daughter!");
        gs.b2.setVisibility(View.INVISIBLE);
        gs.b3.setVisibility(View.INVISIBLE);

        nextPosition1 = "ragnarFight";
    }

    private void gozor() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.gozor1);
        allButtonVisible();
        gs.storyText.setText("You arrive to Gozor territory, the land is dead, full of burned bodies and bones." +
                "Going forward you got the lair of the terrifying dragon. She's apparently not in the lair. You can see" +
                "that your daughter is not here. What will you do next?");

        gs.b1.setText("Set a trap");
        gs.b2.setText("Turn back");
        gs.b3.setVisibility(View.INVISIBLE);

        nextPosition1 = "setTrap";
        if(wand){
            nextPosition2 = "turnbackFromGozorWithWand";
        }
        else{
            nextPosition2 = "turnbackFromGozor";
        }
    }

    private void getTheSword() {
        gs.sv.scrollTo(0,0);
        allButtonVisible();
        gs.img.setImageResource(R.drawable.merchant);
        gs.storyText.setText("You pay for the food and the sword. Now you can visit the sign.");

        gs.b1.setText("Approach the sign");
        gs.b2.setVisibility(View.INVISIBLE);
        gs.b3.setVisibility(View.INVISIBLE);

        nextPosition1 = "sign";

        sword=true;
    }

    private void killTheMerchant() {
        gs.sv.scrollTo(0,0);
        allButtonVisible();
        gs.img.setImageResource(R.drawable.merchant);
        gs.storyText.setText("You don't like the merchant's face, so you decide to kill him." +
                "You are obviously stronger than the merchant, you win easily. What will you do next?");

        gs.b1.setText("Grab food and sword and go to sign");
        gs.b2.setVisibility(View.INVISIBLE);
        gs.b3.setVisibility(View.INVISIBLE);

        nextPosition1 = "sign";

        sword=true;
    }

    private void begForFood() {
        gs.sv.scrollTo(0,0);
        allButtonVisible();
        gs.img.setImageResource(R.drawable.merchant);
        gs.storyText.setText("The merchant makes fun of you, then chase you away. What will you do next?");

        gs.b1.setText("Kill him");
        gs.b2.setText("Leave and approach the sign");
        gs.b3.setVisibility(View.INVISIBLE);

        nextPosition1 = "killTheMerchant";
        nextPosition2 = "sign";
        nextPosition3 = "";
    }

    private void merchant() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.merchant);
        if (gold==0){
            allButtonVisible();
            gs.storyText.setText("The merchant greets you. Unfortunately you don't have any gold. What will you do next?");

            gs.b1.setText("Beg for food");
            gs.b2.setText("Leave and approach the sign");
            gs.b3.setText("Kill the merchant");

            nextPosition1 = "begForFood";
            nextPosition2 = "sign";
            nextPosition3 = "killTheMerchant";
        }
        else{
            allButtonVisible();
            gs.sv.scrollTo(0,0);
            gs.storyText.setText("The merchant greets you. Fortunately you found some gold in the dwarf's hut. " +
                    "You can buy food for 1 gold for yourself and for Peckes, and you can buy a huge great sword. What will you do next?");

            gs.b1.setText("Purchase food and sword");
            gs.b2.setText("Leave and approach the sign");
            gs.b3.setText("Kill the merchant");

            nextPosition1 = "getTheSword";
            nextPosition2 = "sign";
            nextPosition3 = "killTheMerchant";
        }
    }

    private void sign() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.sign);
        beatRagnar=false;
        beatGozor=false;
        allButtonVisible();
        gs.storyText.setText("You step closer to the sign." +
                " It says:\nTurn left if you want to reach Gozor, the fire dragon\n" +
                "Turn right if you want to reach Ragnar, the ice giant\n" +
                "Go ahead if you want to reach the witch\n  What will you do next?");

        gs.b1.setText("Turn left");
        gs.b2.setText("Turn right");
        gs.b3.setText("Go ahead");

        nextPosition1 = "gozor";
        nextPosition2 = "ragnar";
        nextPosition3 = "witch";
    }

    private void reachTheCrossroads() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.crossroads);
        beatGozor=false;
        beatRagnar=false;
        allButtonVisible();
        gs.storyText.setText("You find yourself at a three way crossroad. In front of you there is" +
                " the sign of the crossroad and next to it there is a merchant wagon. What will you do next?");

        gs.b1.setText("Approach the sign");
        gs.b2.setText("Approach the merchant");
        gs.b3.setVisibility(View.INVISIBLE);

        nextPosition1 = "sign";
        nextPosition2 = "merchant";
    }

    private void dwarfsBeated() {
        gs.sv.scrollTo(0,0);
        allButtonVisible();
        gs.img.setImageResource(R.drawable.dwarf);
        gs.storyText.setText("The mind trick worked! The dwarf hit his head and passed out. You have the opportunity to " +
                "finish him with his dagger. Now you are free to explore the hut. In a secret room you finds 500 gold. " +
                "What will you do next?");

        gs.b1.setText("leave island");
        gs.b2.setVisibility(View.INVISIBLE);
        gs.b3.setVisibility(View.INVISIBLE);

        nextPosition1 = "islandChecked";
        gold+=500;
    }

    private void deadWithSpoon() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.dwarf);
        allButtonVisible();
        gs.storyText.setText("The spoon wasn't very effective. You are dead.");

        gs.b1.setText("return to the last checkpoint");
        gs.b2.setVisibility(View.INVISIBLE);
        gs.b3.setVisibility(View.INVISIBLE);

        nextPosition1 = "crossTheBridge";
    }

    private void useMindTrick() { //sensor
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.dwarf);
        acceloOn=true;
        allButtonVisible();
        gs.storyText.setText("Your mind force is exceptional, you're trying hard to make the dwarf fall. Try it harder!");
        gs.b1.setVisibility(View.INVISIBLE);
        gs.b2.setVisibility(View.INVISIBLE);
        gs.b3.setVisibility(View.INVISIBLE);



    } //sensor

    private void islandChecked() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.bridge);
        allButtonVisible();
        gs.storyText.setText("After you leaves the island you get back to the bridge. You are very tired," +
                "you have to rest, so you camp next to bridge. In the morning you wakes up fully energized. What will you do next?");

        gs.b1.setText("Continue follow the river");
        gs.b2.setText("Head towards the mountains");
        gs.b3.setVisibility(View.INVISIBLE);

        nextPosition1 = "continueFollowTheRiver";
        nextPosition2 = "reachTheCrossroads";
    }

    private void dieInDwarfsHut() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.dwarf);
        allButtonVisible();
        gs.storyText.setText("When you reach the door you realised it is locked. You trying to bust it" +
                ", but it is too heavy. The dwarf catch up and back stabs you several times with his rusty and dull dagger." +
                "You collapse to the floor and die horribly.");

        gs.b1.setText("return to the last checkpoint");
        gs.b2.setVisibility(View.INVISIBLE);
        gs.b3.setVisibility(View.INVISIBLE);

        nextPosition1 = "reachTheBridge";
    }

    private void successEscapeFromDwarf() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.dwarf);
        allButtonVisible();
        gs.storyText.setText("You jump out of the window and run to Peckes. He is glad to see you again." +
                " You have to leave the island quickly.");

        gs.b1.setText("Leave the island");
        gs.b2.setVisibility(View.INVISIBLE);
        gs.b3.setVisibility(View.INVISIBLE);

        nextPosition1 = "islandChecked";
    }

    private void escapeFromDwarf() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.dwarf);
        allButtonVisible();
        gs.storyText.setText("The dwarf squeezes you into the corner, but you're faster and you have a moment to breath." +
                "You have to decide your escape route quickly. What will you do next? ");

        gs.b1.setText("Try jump out of the window ");
        gs.b2.setText("Try escape through the door");
        gs.b3.setVisibility(View.INVISIBLE);

        nextPosition1 = "successEscapeFromDwarf";
        nextPosition2 = "dieInDwarfsHut";
    }

    private void beatTheDwarf() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.dwarf);
        allButtonVisible();
        gs.storyText.setText("You don't have any weapon, just your strong mind. You remember a very ancient" +
                "mind trick which can be useful. What will you do next?");

        gs.b1.setText("Use the mind trick");
        gs.b2.setText("Try to beat him with a spoon");
        gs.b3.setVisibility(View.INVISIBLE);

        nextPosition1 = "useMindTrick";
        nextPosition2 = "deadWithSpoon";
    }

    private void continueFollowTheRiver() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.pecek);
        allButtonVisible();
        gs.storyText.setText("The river leads to a waterfall. You step closer to the edge, it's a beautiful view." +
                "Suddenly a giant octopus falls down the waterfall and with one of his tentacle grabs your feet and drags you" +
                " into the deep. You are dead.");

        gs.b1.setText("Return to the last checkpoint");
        gs.b2.setVisibility(View.INVISIBLE);
        gs.b3.setVisibility(View.INVISIBLE);

        nextPosition1 = "stable";
    }

    private void crossTheBridge() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.hut);
        allButtonVisible();
        gs.storyText.setText("When you go deeper into the island, it becomes more and more scary. " +
                "In the middle of the island you see an ugly hut. You get off Peckes and take a look closer." +
                "You try to get inside, but the door is locked. You go to the nearest window where all of a sudden " +
                "a terrifying dwarf drags you into the house. He acts very hostile. What will you do next?");

        gs.b1.setText("Try to beat him");
        gs.b2.setText("Try to escape");
        gs.b3.setVisibility(View.INVISIBLE);

        nextPosition1 = "beatTheDwarf";
        nextPosition2 = "escapeFromDwarf";
    }

    private void foundTheCrossbow() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.chest);
        allButtonVisible();
        gs.storyText.setText("The path is not too long, it leads into a small room where you find a chest." +
                "You take a closer look, open the chest. A big rat scares you, jumps out from chest. At the bottom of the chest" +
                "you see an epic crossbow. It could be useful, you take it. What will you do next?");

        gs.b1.setText("Follow the footprints on the road");
        gs.b2.setVisibility(View.INVISIBLE);
        gs.b3.setVisibility(View.INVISIBLE);

        nextPosition1 = "reachTheCrossroads";

        crossbow=true;
    }

    private void reachTheBridge() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.bridge);
        allButtonVisible();
        gs.storyText.setText("During trotting alongside the river you notice a bridge which is leads to a seemingly dark and unfriendly island." +
                "What will you do next?");

        gs.b1.setText("Cross the bridge");
        gs.b2.setText("Continue follow the river");
        gs.b3.setText("Head towards the mountains");

        nextPosition1 = "crossTheBridge";
        nextPosition2 = "continueFollowTheRiver";
        nextPosition3 = "reachTheCrossroads";
    }

    private void goDeeperIntoCave() {
        gs.sv.scrollTo(0,0);
        allButtonVisible();
        gs.img.setImageResource(R.drawable.pathincave);
        gs.storyText.setText("You go deeper into the cave where you find a hidden and narrow path you don't know" +
                "where it leads. It can be dangerous. What will you do next?");

        gs.b1.setText("Follow the hidden path");
        gs.b2.setText("Turn back and follow the road");
        gs.b3.setVisibility(View.INVISIBLE);


        nextPosition1 = "foundTheCrossbow";
        nextPosition2 = "followFootprintsAfterCave";
    }

    public void killedByTroll() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.troll);
        gs.storyText.setText("You do your best, you break the trolls arm but you don't have a chance in long run." +
                "The troll stupid but strong, and finds you with a fatal blow.");

        gs.b1.setText("return to the last checkpoint");
        gs.b2.setVisibility(View.INVISIBLE);
        gs.b3.setVisibility(View.INVISIBLE);

        nextPosition1 = "startingPoint";
    }

    public void killedByTrollCoward() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.troll);
        gs.storyText.setText("You try to run away, but you are too slow because of injuries. " +
                "The troll will eventually catch you and slam your entire body to the ground multiple times.");

        gs.b1.setText("return to the last checkpoint");
        gs.b2.setVisibility(View.INVISIBLE);
        gs.b3.setVisibility(View.INVISIBLE);

        nextPosition1 = "startingPoint";
    }

    public void foundPotionInCave() { //troll kitrükközve
        gs.sv.scrollTo(0,0);
        allButtonVisible();
        gs.img.setImageResource(R.drawable.troll);
        gs.storyText.setText("You are way smarter than the troll. It's almost sunrise and you bait the troll to the entrance of the cave." +
                "The stupid steps out of the cave to the sunshine and became stone. Now the troll is gone, you will searched cave" +
                "and find valuable treasures, a warm cloth and a healing potion which is capable to heal the injuries instantly." +
                "You drink the potion and wear the clothes. You are ready to continue the rescue mission. What will you do next?");

        gs.b1.setText("Follow the footprints on the road");
        gs.b2.setText("You go deeper into the cave");
        gs.b3.setVisibility(View.INVISIBLE);

        nextPosition1 = "reachTheCrossroads";
        nextPosition2 = "goDeeperIntoCave";
        fullHeal=true;
        cloth=true;
    }

    public void startingPoint(){
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.bandits);
        allButtonVisible();
    gs.storyText.setText("It's a very dark night..\n\nYou are sleeping and you hear screams from outside. " +
            "You get up and you walk toward to window.\n\nYou see the bandits raiding your village.. " +
            "Suddenly a very bright white light blinds you for a few seconds. \n They are already inside your house. " +
            " You are a skilled fighter, you take 8 bandits down, but there are too many. \n " +
            "You hear you daughter's scream from upstairs. You have just got a final blow. You fall unconscious." +
            " You get up next morning, having a terrible headache and pain. You are wounded. What will you do next?");

    daughter=false;
    gs.b1.setText("Visit the healers house");
    gs.b2.setText("Search for survivors");
    gs.b3.setText("Go to the next village for help");

    nextPosition1 = "healersHouse";
    nextPosition2 = "searchForSurvivors";
    nextPosition3 = "nextVillage";
}

    public void hHouse() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.you);

        gs.storyText.setText("You reach the healers house, the door is busted. " +
                "You search the main hall where you found some bandage and painkiller. Now you feel yourself much better," +
                "so now you are set to find your daughter. What will you do next?");
        allButtonVisible();
        gs.b1.setText("Follow the footprints");
        gs.b2.setText("Check the stable");
        gs.b3.setText("Go upstairs");


        nextPosition1 = "cave";
        nextPosition2 = "stable";
        nextPosition3 = "healerHouseUpstairs";
    }

    public void healerHouseUpstairs() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.monkfall);
        gs.storyText.setText("During walking up the stairs you stumble and fall down. You are dead.");

        gs.b1.setText("return to the last checkpoint");
        gs.b2.setVisibility(View.INVISIBLE);
        gs.b3.setVisibility(View.INVISIBLE);

        nextPosition1 = "startingPoint";
    }

    public void sfSurvivors() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.blacksmith);
        gs.storyText.setText("There are not many survivors, when your walking on the street, you meet the blacksmith." +
                " He's one of your friend and he offers his help and take care of your injury.Now you feel yourself much better," +
            " so now you are set to find your daughter. Harold, the blacksmith can't join you because he has to search for more survivors." +
                "What will you do next?");

        gs.b1.setText("Follow the footprints");
        gs.b2.setText("Check the stable");
        gs.b3.setVisibility(View.INVISIBLE);

        nextPosition1 = "cave";
        nextPosition2 = "stable";
    }

    public void nVillage() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.daughter);
        gs.storyText.setText("You are going down to road to the next village, but half way through you feel you will never reach it." +
                "You're too weak to walk, so you sit down near a big tree, blink at the sky at last time and close your eyes forever. ");

        gs.b1.setText("return to the last checkpoint");
        gs.b2.setVisibility(View.INVISIBLE);
        gs.b3.setVisibility(View.INVISIBLE);

        nextPosition1 = "startingPoint";
    }

    public void cave() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.troll);
        allButtonVisible();
        gs.storyText.setText("You follow the footprints down the main road, follow the tracks until you reach a cave." +
                "Maybe the bandits camp in the cave. You go inside and there are no bandits, just a big hungry troll, who " +
                "instantly attacks you. What will you do next?");

        gs.b1.setText("Try to trick the troll");
        gs.b2.setText("Try to beat the troll with pure strength");
        gs.b3.setText("Run away");


        nextPosition1 = "foundPotionInCave";
        nextPosition2 = "killedByTroll";
        nextPosition3 = "killedByTrollCoward";
    }

    public void stable() {
        gs.sv.scrollTo(0,0);
        gs.img.setImageResource(R.drawable.stable);
        allButtonVisible();
        gs.storyText.setText("When you arrive at the stable you realise that every horses are gone." +
                "Next to the stable you find peckes the donkey. He's not the youngest and he's a bit chubby but still capable." +
                "Now you have your companion, you are ready to save your daughter. What will you do next?");

        gs.b1.setText("You saw the way where the bandits came, you choose that direction");
        gs.b2.setText("Follow the river");
        gs.b3.setVisibility(View.INVISIBLE);

        nextPosition1 = "reachTheCrossroads";
        nextPosition2 = "reachTheBridge";

        peckes=true;
    }





}


