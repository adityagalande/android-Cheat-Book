package com.example.cheatbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TextView;

public class PS4Activity extends AppCompatActivity {

    private String data = " \t\n" +
            "Among Us\n" +
            "\n" +
            "Cheat Codes:\n" +
            "------------\n" +
            "Submitted by: David K.\n" +
            "\n" +
            "Impostor Guide:\n" +
            "---------------\n" +
            "Written by mCs\n" +
            "\n" +
            "An in-depth Impostor tutorial by an actual 5Head.\n" +
            "\n" +
            "-=After the Game Commences=-\n" +
            "Try not to switch up your habbits; if for example you are playing Skiel and 90% \n" +
            "of the time walk LEFT towards Top Engine, don't change where you go just because \n" +
            "you are Impostor, that alone might certain kind of people suspicious.\n" +
            "\n" +
            "Start by faking multiple-step tasks such as Wires, but never do more than the \n" +
            "actual Task requires.\n" +
            "\n" +
            "Mind how long you do the task for, because good players will look out for that so \n" +
            "know how long it takes to do tasks.\n" +
            "\n" +
            "-=Committing to the First Kill=-\n" +
            "Crewmate knowledge is really key to playing impostor because if you act like a \n" +
            "crewmate you will be less likely to be suspected.\n" +
            "\n" +
            "One of the easiest way to get the first kill, is wait for somebody to be completely \n" +
            "isolated, just you and them. If that's the case, then commit to the kill and try to \n" +
            "diverse the Crewmates so that they don't discover the body, the best way is to simply \n" +
            "sabotage on the other side of the map.\n" +
            "\n" +
            "e.g. If you kill somebody in Navigation, sabotage Reactor.) This will help you get \n" +
            "your kill cooldown without having to worry about people finding the body; and this \n" +
            "can obviously lead to you going on a killing spree without anybody reporting bodies \n" +
            "or calling emergency.\n" +
            "\n" +
            "-=After the First-Blood=-\n" +
            "After the first/second kill, it's up to you (and your Impostor friend) to play your \n" +
            "cards right. Try to keep the Crewmates off of reporting the bodies as much as possible.\n" +
            "\n" +
            "A good tip to do that is to try and kill people around corners and places where people \n" +
            "don't intentionally go to.\n" +
            "\n" +
            "Also, don't forget to kill the lights. Decreasing the vision of the Crewmates is \n" +
            "great for hiding bodies and giving your kill-cooldown a chance to recharge.\n" +
            "\n" +
            "If somebody finds the body, try your best to clear yourself and maybe even accuse \n" +
            "somebody out of the blue using a slip up that someone can make when explaining \n" +
            "themselves.\n" +
            "\n" +
            "Also, if you commit to a kill and see somebody running your way, you might aswell \n" +
            "report the body and try blaming the whole thing on them using a variety of persuading \n" +
            "methods.\n" +
            "\n" +
            "\n" +
            "\n" +
            "How to Hunt Down and Root Out the Impostors:\n" +
            "--------------------------------------------\n" +
            "Written by Rat King\n" +
            "\n" +
            "-=Taking the Fight to the Enemy=-\n" +
            "If you are crew, try to actively hunt down the impostor(s). Doing tasks is beneath \n" +
            "you - leave that to the civilians.\n" +
            "\n" +
            "-=Verify and Make a Friend=-\n" +
            "At game start, your objective should be to prove that 1 other person is a crewmate. \n" +
            "Follow someone to a nearby location and ensure they aren't fake tasking by observing \n" +
            "the meter. Once you determine that they are crew go back to the start and use your \n" +
            "emergency meeting. The group will likely be surprised at how early it is and be \n" +
            "annoyed at you that their current task was interrupted.\n" +
            "\n" +
            "-=Use Your First Meeting to Train/Lead the Group=-\n" +
            "Most impostors know that they need to get their first kills very quickly if they are \n" +
            "to succeed. By holding an emergency meeting early, you achieve several things:\n" +
            "\n" +
            "* You can inform the group that the person you verified is in fact safe. This person \n" +
            "  will begin trusting you, even if the rest of the group turns against you out of \n" +
            "  annoyance.\n" +
            "* If the meeting is held early enough, you might disrupt an impostor from getting \n" +
            "  their first kill and delay their kill countdown timer.\n" +
            "* If the impostors did manage to kill one or two crewmates, the survivors will \n" +
            "  know that the people in their vicinity can likely be trusted. This is important \n" +
            "  later on.\n" +
            "* If an impostor was spotted using a vent they will be outed almost immediately.\n" +
            "\n" +
            "-=Focus On Facts=-\n" +
            "In this first meeting, you may be accused of being an impostor. State clearly that \n" +
            "you can prove your innocence by doing a task. Doesn't have to be one of the visible \n" +
            "ones (med scan, shields, weapons or trash), a simple card in admin will work as the \n" +
            "meter will go up when you are done. Any single-step task will do (so not rewiring, \n" +
            "download etc). Immediately switch the conversation to who has intel to share with \n" +
            "each other (who has scans/trash etc). That will remind the crew that their job is \n" +
            "not to complete tasks, it is to root out who cannot be trusted.\n" +
            "\n" +
            "-=Start The Hunt=-\n" +
            "Doing all this will help focus the group on observing each other's movements and \n" +
            "actions. Most impostors just play a solo, run around looking for lonesome victims \n" +
            "kind of game. They duck and weave and change direction on the fly. With this start, \n" +
            "they might get a few more kills but by the end, the remaining survivors will likely \n" +
            "figure out that 3-4 of them are actually safe and will start operating as a group. \n" +
            "Most impostor(s) will not be able to think or adapt fast enough. Some impostors \n" +
            "will try to tag along....\n" +
            "\n" +
            "-=Late Game - Avoiding Impostors Out to Get You=\n" +
            "Once the impostors see that you are using logic in chat to coordinate who is \n" +
            "verified as safe (focus on that, not wild accusations) you will become a target. \n" +
            "Try to travel with other safe people but then switch up and pull away on your own. \n" +
            "Impostors in your 'safe' group will be intent on cornering you by yourself.\n" +
            "\n" +
            "Use that! Try to keep distance between you and them so they can't kill you (they \n" +
            "will start getting desperate and try for kills out in the open). If they chase \n" +
            "you, they are losing time and not killing crewmates. If they give up, move back \n" +
            "so they are back in your line of sight. Do this a few times and you will quickly \n" +
            "determine if they are an impostor or not. Also, be on the lookout for players \n" +
            "moving in the opposite direction away from a crisis, or who frequently pause, \n" +
            "stop moving and double back.\n" +
            "\n" +
            "-=It's All About The Numbers=-\n" +
            "* As numbers dwindle, many players lose sight of the fact that the impostors can \n" +
            "  quickly rack up a few kills and win the game.\n" +
            "* If 3 players are alive, the impostor is just 1 kill away from winning the game.\n" +
            "* If 5 players alive (and there are 2 impostors), they are just 1 kill away from \n" +
            "  winning the game.\n" +
            "\n" +
            "Consequently the choices made by the crew when there are 4 or 6 players left \n" +
            "pretty much determines the outcome of the match. Assuming you have verified that \n" +
            "1 or 2 others are safe, focus on the remaining players and have your group discuss \n" +
            "who is most suspect. You need to take this 50-66% chance of voting out an impostor \n" +
            "at this stage. Sharing last minute intel (and seeing who is not speaking too) will \n" +
            "massively boost the group's ability to make the right call.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_s4);
        TextView textView = (TextView) findViewById(R.id.gamaname);
        textView.setText(data);
    }
}