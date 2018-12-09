package com.superprofan.dict1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class LearningActivity extends AppCompatActivity {

    private TextSwitcher mSwitcher;
    private int mCounter = 0;
    //TextView t;

    String[][]cards={
            //english
            {
                "abradable - истираемый", "quaint - странный, чудной, необычный, своеобразный",
                "volatile - 1) летящий; летающий, способный летать 2) непостоянный, изменчивый; неуловимый, переменный",
                "ensconce - 1) укрывать, прятать 2) устраивать (с удобством)", "wizened - shrivelled or wrinkled with age",
                "crone - an ugly old woman", "surreptitiously - тайно, скрытно; исподтишка, тайком", "discard - избавляться от чего-л. (отбрасывать, выбрасывать за ненадобностью)"
            },
            //french
            {
                "discipliné [disipline] - disciplinée дисциплинированный", "eau crue 1) жёсткая вода 2) сырая вода", "ébauché - e намеченный; наметившийся",
                "ébouriffer [ebuʀife] 1) растрепать, взъерошить (волосы) 2) ошеломлять; поражать", "ozonite - отбеливающее средство",
                "pacifique [pasifik] - миролюбивый, мирный", "rythmicité [ʀitmisite] ритмичность", "s'affilier (à qch) присоединяться, примыкать к…, входить в…"
            },

            //german
            {
             "stoßweise - толчками; кипами, стопами", "Inbegriff - высшее проявление, воплощение; идеал", "Rechtschaffenheit честность, прямота, правдивость, порядочность",
             "verdutzt - озадаченный, смущённый", "entkoppeln - разъединять, расцеплять", "Verlies -es, -e подземелье; темница", "Gesichtspunkt - точка зрения",
             "grimmig 1. яростный, свирепый, лютый, жестокий", "Kopfgeld награда за голову преступника"
            },
            //spanish
            {
              "la tuya 1) твой шанс, удобный случай для тебя", "laberintiforme лабиринтообразный, извилистый", "la vaca de la boda 1) шут; затейник 2) палочка-выручалочка",
              "obcecarse 1) ослепнуть; потерять зрение 2) быть в ослеплении; потерять разум", "habanera I 1. гаванский 2. 1) гаванец, гаванка 2) \"американец\" (об испанце, разбогатевшем в Америке)",
              "tabacal - табачная плантация", "tabarra - утомительный (нудный) разговор", "yuyo , , 1) дикая, лесная, степная трава 2) сорная трава; сорняк; бурьян",
              "zabuir - окунать в воду", "zuzar - науськивать, натравливать", "mutuo - взаимный; обоюдный", "cuatalata - 1) большеголовый 2) упорный, настойчивый; упрямый",
              "nacasma - муравей", "quizá(s) - возможно; может быть; наверно(е); пожалуй"
            },
            //java
            {
              "java.base - Defines the foundational APIs of the Java SE Platform.",
              "java.compiler\t Defines the Language Model, Annotation Processing, and Java Compiler APIs.",
              "java.naming - Defines the Java Naming and Directory Interface (JNDI) API.",
              "java.net.http - Defines the HTTP Client and WebSocket APIs.",
              "jdk.accessibility - Defines JDK utility classes used by implementors of Assistive Technologies.",
              "jdk.zipfs - Provides the implementation of the zip file system provider."
            },
            //html
            {
             "HTML headings are defined with the <h1> to <h6> tags. <h1> defines the most important heading. <h6> defines the least important heading",
             "An HTML element usually consists of a start tag and end tag, with the content inserted in between: <tagname>Content goes here...</tagname>",
             "The HTML <p> element defines a paragraph. Note: Browsers automatically add some white space (a margin) before and after a paragraph.",
             "HTML Formatting Elements\n" +
                    "In the previous chapter, you learned about the HTML style attribute.\n" +
                    "\n" +
                    "HTML also defines special elements for defining text with a special meaning.\n" +
                    "\n" +
                    "HTML uses elements like <b> and <i> for formatting output, like bold or italic text.\n" +
                    "\n" +
                    "Formatting elements were designed to display special types of text:\n" +
                    "\n" +
                    "<b> - Bold text\n" +
                    "<strong> - Important text\n" +
                    "<i> - Italic text\n" +
                    "<em> - Emphasized text\n" +
                    "<mark> - Marked text\n" +
                    "<small> - Small text\n" +
                    "<del> - Deleted text\n" +
                    "<ins> - Inserted text\n" +
                    "<sub> - Subscript text\n" +
                    "<sup> - Superscript text",
             "The HTML <q> element defines a short quotation.\n" +
                     "<b> - Bold text\n" +
                     "<strong> - Important text\n" +
                     "<i> - Italic text\n" +
                     "<em> - Emphasized text\n" +
                     "<mark> - Marked text\n" +
                     "<small> - Small text\n" +
                     "<del> - Deleted text\n" +
                     "<ins> - Inserted text\n" +
                     "<sub> - Subscript text\n" +
                     "<sup> - Superscript text",
             "HTML colors are specified using predefined color names, or RGB, HEX, HSL, RGBA, HSLA values."
            }
    };
    String[]cardsChosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);

        Intent i = getIntent();
        final int position = i.getExtras().getInt("id");
        cardsChosen = cards[position];

        mSwitcher = findViewById(R.id.switcher);
        mSwitcher.setFactory(mFactory);
        mSwitcher.setText(String.valueOf(cardsChosen[mCounter]));

        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        mSwitcher.setInAnimation(in);
        mSwitcher.setOutAnimation(out);


        Button nextButton = findViewById(R.id.buttonnext);
        Button previousButton = findViewById(R.id.buttonprevious);


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mCounter<cardsChosen.length-1){
                    mCounter++;
                }else {
                    mCounter = 0;
                }
                // BEGIN_INCLUDE(settext)
                mSwitcher.setText(String.valueOf(cardsChosen[mCounter]));
                // END_INCLUDE(settext)
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mCounter>0){
                    mCounter--;
                }else{
                    mCounter = cardsChosen.length-1;
                }
                mSwitcher.setText(String.valueOf(cardsChosen[mCounter]));
            }
        });



    }

    // BEGIN_INCLUDE(factory)
    /**
     * The {@link android.widget.ViewSwitcher.ViewFactory} used to create {@link android.widget.TextView}s that the
     * {@link android.widget.TextSwitcher} will switch between.
     */
    private ViewSwitcher.ViewFactory mFactory = new ViewSwitcher.ViewFactory(){
        @Override
        public View makeView() {
            // Create a new TextView
            TextView t = new TextView(LearningActivity.this);
            t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
            t.setTextAppearance(LearningActivity.this, android.R.style.TextAppearance_Large);
            return t;
        }
    };
    // END_INCLUDE(factory)
}
