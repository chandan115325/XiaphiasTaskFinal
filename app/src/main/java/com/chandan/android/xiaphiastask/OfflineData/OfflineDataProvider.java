package com.chandan.android.xiaphiastask.OfflineData;

import com.chandan.android.xiaphiastask.R;
import com.chandan.android.xiaphiastask.model.DataItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// * Created by CHANDAN on 11/26/2017.



public class OfflineDataProvider {

    public static List<DataItem> dataItemList;
    public static Map<String, DataItem> dataItemMap;

    static {
        dataItemList = new ArrayList<>();
        dataItemMap = new HashMap<>();

        addItem(new DataItem(
                "RCB Insider Show 2.0 | Virat Kohli paints Nags red!",
                "After banter that left Kohli in splits, Nags challenged the skipper to a paint-off! Watch both Nags and Kohli lose the plot, throw the script out of the window and ...",
                "image_1.jpg",
                "2016-05-23T07:38:12.000Z",
                "1kuSMW3rdP4",
                "\"ld9biNPKjAjgjV7EZ4EKeEGrhao/g6iIdnt7YZA8ADGNHT89u3g_7Xw\"",
                "Royal Challengers Bangalore",
                    R.drawable.image_1

        ));

        addItem(new DataItem(
                "Round 3: Nags vs. Virat",
                "Finally Kohli and the #RCBInsider sat down to talk things out so there's some #Peas. But will #Peas prevail?",
                "https://i.ytimg.com/vi/etr9Bqix1pg/hqdefault.jpg",
                "2015-05-10T09:31:26.000Z",
                "etr9Bqix1pg",
                "\"ld9biNPKjAjgjV7EZ4EKeEGrhao/6k6NoLTt-ZTvW2cjOt4Gazr4zTc\"",
                "Royal Challengers Bangalore",
                R.drawable.image_2
        ));

        addItem(new DataItem(
                "The RCBInsider Show ft. AB de Villiers!",
                "Watch Mr.360 take on his biggest challenge yet i.e. face the googlies of the #RCBInsider!",
                "https://i.ytimg.com/vi/e0XwQCNhZmU/hqdefault.jpg",
                "2015-04-19T05:04:58.000Z",
                "e0XwQCNhZmU",
                "\"ld9biNPKjAjgjV7EZ4EKeEGrhao/XHSxaH8xiqHteJxNYq5a4oZDB78\"",
                "Royal Challengers Bangalore",R.drawable.image_3
        ));

        addItem(new DataItem(
                "Do the Nags Feat. Brodha V | RCB Insider 3.0",
                "Mr Nags went to the hills on a journey of self discovery and came back with this pumping song! Join him and Do the NAGS! #PlayBold #RCB #VIVOIPL2017 ...",
                "https://i.ytimg.com/vi/93jfAI1JaqU/hqdefault.jpg",
                "2017-04-04T10:49:48.000Z",
                "93jfAI1JaqU",
                "\"ld9biNPKjAjgjV7EZ4EKeEGrhao/ssST5Fe2ywLjPaB0EqfaOk9FwvA\"",
                "Royal Challengers Bangalore",R.drawable.image_4
        ));

        addItem(new DataItem(
                "The Nags Conspiracy | Insider 3.0",
                "He hinted at it in his song and now Nags has gone and done it, he's fooled Virat and conned the whole team into playing for him! Watch what happened!",
                "https://i.ytimg.com/vi/kG0-aS0iuhw/hqdefault.jpg",
                "2017-04-07T14:38:24.000Z",
                "kG0-aS0iuhw",
                "\"ld9biNPKjAjgjV7EZ4EKeEGrhao/hlT9ebQofU4r4nqmgnYS3in73JU\"",
                "Royal Challengers Bangalore",R.drawable.image_5
        ));

        addItem(new DataItem(
                "Here is the #RCBInsider!",
                "The guess work ends here. Here he is on camera, the new RCBian - the RCB Insider! For you he will go where no one else goes to show you what no one else ...",
                "https://i.ytimg.com/vi/8eF3jvZ0uTA/hqdefault.jpg",
                "2015-04-07T07:16:39.000Z",
                "8eF3jvZ0uTA",
                "\"ld9biNPKjAjgjV7EZ4EKeEGrhao/HHAqcamYbx83OdNylyuptVw-xb0\"",
                "Royal Challengers Bangalore",R.drawable.image_6
        ));

        addItem(new DataItem(
                "RCB Insider Show 2.0 | The Kannadiga Trio!",
                "Nags got RCB's Kannadiga Trio – Stuart Binny, KL Rahul and Sreenath Aravind had a barbershop conversation, literally - styling KL's hair and even getting ...",
                "https://i.ytimg.com/vi/vw4QEBKEvGQ/hqdefault.jpg",
                "2016-05-21T07:29:46.000Z",
                "vw4QEBKEvGQ",
                "\"ld9biNPKjAjgjV7EZ4EKeEGrhao/YSTSryRn2RpuA_0P4ZbLk-bxQ9c\"",
                "Royal Challengers Bangalore",R.drawable.image_7
        ));

        addItem(new DataItem(
                "The RCB Insider song | Ft. Nags & Nikhil Chinapa",
                "Pump up the volume and keep those feet tapping! Because the most wicked beats of VIVO IPL 9 are here! Pssst… Kohli, Watto, Gayle, AB and many other ...",
                "https://i.ytimg.com/vi/YDOtQKRMNt0/hqdefault.jpg",
                "2016-05-08T06:45:25.000Z",
                "YDOtQKRMNt0",
                "\"ld9biNPKjAjgjV7EZ4EKeEGrhao/HQp--k0KQP1W3UQ56dEw64Zb_tY\"",
                "Royal Challengers Bangalore",R.drawable.image_8
        ));

        addItem(new DataItem(
                "RCB Insider Show 2.0 | AB de Villiers",
                "Nags is back - with twice the antics, craziness and absurdity! And he's got a hold of AB again! Why does AB keep falling for this? Watch and find out!",
                "https://i.ytimg.com/vi/Y4M7v9t6zig/hqdefault.jpg",
                "2016-05-15T12:20:11.000Z",
                "Y4M7v9t6zig",
                "\"ld9biNPKjAjgjV7EZ4EKeEGrhao/zof2FuLK3BZoVA-5lRjzrh4sXZo\"",
                "Royal Challengers Bangalore",R.drawable.image_9
        ));

        addItem(new DataItem(
                "Yet another party crashed by the RCB Insider!",
                "After being shoved out of two shoots, the RCB insider finally gets a chance to confront Virat Kohli at the post-match party! What happened next you ask? Watch ...",
                "https://i.ytimg.com/vi/zLOEP3H1xc0/hqdefault.jpg",
                "2015-04-13T07:12:03.000Z",
                "zLOEP3H1xc0",
                "\"ld9biNPKjAjgjV7EZ4EKeEGrhao/m75JBFHhLzB8p-DWcS6BPzNO7jc\"",
                "Royal Challengers Bangalore",R.drawable.image_10
        ));

        addItem(new DataItem(
                "AnonyNags’ act of #Waar!",
                "The bugle of #Waar has been sounded! Unhappy with the #RCBInsider not being selected in the team, AnonyNags has taken over the Chinnaswamy!",
                "https://i.ytimg.com/vi/sqN14X0nzwY/hqdefault.jpg",
                "2016-04-09T09:33:58.000Z",
                "sqN14X0nzwY",
                "\"ld9biNPKjAjgjV7EZ4EKeEGrhao/TFdrJFQhWvxSFuvY53D9ufykBG8\"",
                "Royal Challengers Bangalore",R.drawable.image_11
        ));

        addItem(new DataItem(
                "The King has returned! and Mr. Nags had a big part in it | Insider 3.0",
                "Mr. Nags is at the Chinnaswamy and has taken over! Watch the #Insider 3.0 video, brought to you by Captain Morgan Cola and AbhiBus.com, as he reveals the ...",
                "https://i.ytimg.com/vi/9UqX9izEXIE/hqdefault.jpg",
                "2017-04-14T07:53:41.000Z",
                "9UqX9izEXIE",
                "\"ld9biNPKjAjgjV7EZ4EKeEGrhao/NNVBf0YK_Zv0ESvOD6mTOjMxtCk\"",
                "Royal Challengers Bangalore",R.drawable.image_12
        ));

        addItem(new DataItem(
                "Finally, Universe Boss Chris Gayle, on the Insider Show! | RCB Insider 3.0",
                "The Universe Boss Chris Gayle makes his first ever appearance on Mr Nags's RCB Insider Show to talk about what took so long, his impending takeover of ...",
                "https://i.ytimg.com/vi/CUK6I7Mu7wY/hqdefault.jpg",
                "2017-05-09T15:01:51.000Z",
                "CUK6I7Mu7wY",
                "\"ld9biNPKjAjgjV7EZ4EKeEGrhao/ZMMXfgVcaEGA024kymS0Ca-b0KE\"",
                "Royal Challengers Bangalore",R.drawable.image_13
        ));

        addItem(new DataItem(
                "Nags treats Challengers to a smashing time!",
                "To make up for his earlier declaration of #Waar, Nags threw the boys a party. Did they accept his peace offering? Watch and find out!",
                "https://i.ytimg.com/vi/mHNcNWFS0rs/hqdefault.jpg",
                "2016-04-16T14:06:37.000Z",
                "mHNcNWFS0rs",
                "\"ld9biNPKjAjgjV7EZ4EKeEGrhao/17HvwXA6WiS3Rn_F-cluRkEC2ig\"",
                "Royal Challengers Bangalore",R.drawable.image_14
        ));

        addItem(new DataItem(
                "Bend it like Nags! | RCB Insider 3.0",
                "The #RCBInsider joined the boys for a game of football at the Eden Gardens and he managed to score a goal! Watch out for his skills in the latest Insider ...",
                "https://i.ytimg.com/vi/xgl15S0RLgE/hqdefault.jpg",
                "2017-04-23T10:26:50.000Z",
                "xgl15S0RLgE",
                "\"ld9biNPKjAjgjV7EZ4EKeEGrhao/akHULjCAU4T5LWVW3YEeRdYEmes\"",
                "Royal Challengers Bangalore",R.drawable.image_15
        ));

        addItem(new DataItem(
                "Nags on a plane!",
                "No safety instruction can prepare you for when Nags takes over the cockpit of a plane! Watch RCB players talk about the flight from hell as Nags flew them from ...",
                "Nags on a plane!",
                "2016-04-24T09:02:53.000Z",
                "Ce--ibBgmso",
                "\"ld9biNPKjAjgjV7EZ4EKeEGrhao/oeFWZOBBsjLHvQAox9_ccyMB5WE\"",
                "Royal Challengers Bangalore",R.drawable.image_16
        ));

        addItem(new DataItem(
                "No bhangda barred with RCB!",
                "The happiness and excitement bubbling in the veins of our players came out as dance and song after the Raipur win! Watch them shake a leg to the banging ...",
                "https://i.ytimg.com/vi/jU0B8hQBjQU/hqdefault.jpg",
                "2016-05-24T18:41:04.000Z",
                "jU0B8hQBjQU",
                "\"ld9biNPKjAjgjV7EZ4EKeEGrhao/B-qj3bFvj3YKAb5ufnYDX-UQ8Sc\"",
                "Royal Challengers Bangalore",R.drawable.image_17
        ));

        addItem(new DataItem(
                "The #RCBInsider delays flight, angers Captain Kohli!",
                "The players were pretty ticked off when the #RCBInsider was late for the flight to Mumbai. Watch Kohli give it to him like he gives it to the opposition bowlers ...",
                "https://i.ytimg.com/vi/IDs0exx_UpM/hqdefault.jpg",
                "2015-05-08T17:24:02.000Z",
                "IDs0exx_UpM",
                "\"ld9biNPKjAjgjV7EZ4EKeEGrhao/-tF_U10jZVyqpbatNSK7_zA5BQE\"",
                "Royal Challengers Bangalore",R.drawable.image_18
        ));

        addItem(new DataItem(
                "When you say nothing at all | AB ft. Danielle de Villier",
                "AB and his wife performed a splendid cover of Ronan Keating's 'When you say nothing at all' for us! Sit yourself comfortably, put on your headphones and relax ...",
                "https://i.ytimg.com/vi/SvRm9KQ7UnY/hqdefault.jpg",
                "2016-05-27T08:47:25.000Z",
                "SvRm9KQ7UnY",
                "\"ld9biNPKjAjgjV7EZ4EKeEGrhao/NIEyzXO6-Z-xE7hF88eyzsiFav4\"",
                "Royal Challengers Bangalore",R.drawable.image_19
        ));

        addItem(new DataItem(
                "#RCBvKXIP | Celebrations after the kingly win!",
                "Nags caught up with everyone at an elated RCB camp after the massive win over Kings XI Punjab. Watto, Gayle, Trent; no one could stop piling praises on Kohli!",
                "https://i.ytimg.com/vi/rF_ANJ0dXww/hqdefault.jpg",
                "2016-05-19T09:08:00.000Z",
                "rF_ANJ0dXww",
                "\"ld9biNPKjAjgjV7EZ4EKeEGrhao/diIOrZm7F1hCH81QJHf4foT7iAg\"",
                "Royal Challengers Bangalore",R.drawable.image_20
        ));
    }







    private static void addItem(DataItem item) {
        dataItemList.add(item);
        dataItemMap.put(item.getEtag(), item);
    }
}
