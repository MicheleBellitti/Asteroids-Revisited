import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class OptionMouseListener extends MouseAdapter {
    private Handler handler;
    int mx, my;

    public OptionMouseListener(Handler handler) {
        this.handler = handler;

    }

    public void mouseClicked(MouseEvent e) {
        mx = e.getX();
        my = e.getY();


                        if (OptionPanel.on && !StartMenu.on) {
                            if (mx >= 330 && mx <= 430) { //sfondo
                                if (my >= 250 && my <= 300) {
                                    OptionPanel.on = false;
                                    Sfondo.on = true;

                                }

                            }

                            if (mx >= 333 && mx <= 433) { //difficolta
                                if (my >= 350 && my <= 400) {
                                    System.out.println("DIFFICOLTA");

                                }

                            }

                            if (mx >= 343 && mx < 426) { //suono
                                if (my >= 450 && my <= 500) {
                                    System.out.println("SUONO");

                                }

                            }
                            if(!StartMenu.on){ //back
                                if(mx >= 640 && mx <= 710){
                                    if(my>= 500  && my <= 545){
                                        OptionPanel.on=false;
                                        StartMenu.on=true;
                                    }
                                }
                            }


                        }
                    }




                }




