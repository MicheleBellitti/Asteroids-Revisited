import java.awt.*;
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
                        MovementSettings.changed=!MovementSettings.changed;
                        if(ms.getKey(0).equals("UP")) {
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
                        MovementSettings.changed=!MovementSettings.changed;
                        if(ms.getKey(1).equals("LEFT")) {
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
                        MovementSettings.changed=!MovementSettings.changed;
                        if(ms.getKey(2).equals("RIGHT")) {
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
                        MovementSettings.changed=!MovementSettings.changed;
                        if(ms.getKey(3).equals("DOWN")) {
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
                            StartMenu.on=false;
                            Difficulty.on=false;
                            OptionPanel.on=true;
                            Sfondo.on=false;
                            GameOverScreen.on=false;
                            Game.on=false;
                            MovementSettings.on=false;


                        }

                    }
                }


            }
        }




    }


