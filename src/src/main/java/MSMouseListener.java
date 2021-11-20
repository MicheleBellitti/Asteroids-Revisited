import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



    public class MSMouseListener extends MouseAdapter {
        private String key;
        private Handler handler;
        private MovementSettings ms;
        int mx, my;

        public MSMouseListener(Handler handler,MovementSettings ms) {
            this.handler = handler;
            this.ms=ms;
        }

        public void mouseClicked(MouseEvent e) {
            mx = e.getX();
            my = e.getY();

            if (!OptionPanel.on && MovementSettings.on) {
                if (mx >= 330 && mx <= 430) {
                    if (my >= 250 && my <= 300) {
                        if(ms.getKey(0)=="UP") {
                            key = "W";
                        }
                        else{
                            key = "UP";
                        }

                        ms.setKey(key,0);
                        System.out.println(ms.getKey(0));

                    }

                }

                if (mx >= 333 && mx <= 433) {
                    if (my >= 350 && my <= 400) {
                        if(ms.getKey(1)=="LEFT") {
                            key = "A";

                        }
                        else{
                            key = "LEFT";
                        }

                        ms.setKey(key,1);


                    }

                }

                if (mx >= 342 && mx < 342+75) {
                    if (my >= 150 && my <= 200) {
                        if(ms.getKey(2)=="RIGHT") {
                            key = "D";
                        }
                        else{
                            key = "RIGHT";
                        }
                        ms.setKey(key,2);

                    }

                }
                if (mx >= 343 && mx < 343+83) {
                    if (my >= 450 && my <= 500) {
                        if(ms.getKey(3)=="DOWN") {
                            key = "S";
                        }
                        else{
                            key = "DOWN";
                        }
                        ms.setKey(key,3);

                    }

                }

                if(!StartMenu.on && !OptionPanel.on) {
                    if (mx >= 640 && mx < 705) {
                        if (my >= 500 && my <= 545) {
                            MovementSettings.on = false;
                            OptionPanel.on = true;


                        }

                    }
                }


            }
        }




    }


