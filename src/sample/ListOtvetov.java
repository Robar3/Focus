package sample;

import java.util.ArrayList;

public class ListOtvetov {
    public ArrayList<Integer> otvetList(){
        int aee[] =new int[100];
        ArrayList<Integer> arrrr=new ArrayList<Integer>();
        for (int s = 0; s < 100; s++) {
            aee[s]=s;
        }
        for (int o = aee.length; o>10 ; o--) {
            for (int w = 10; w < aee.length; w++) {
            String dd=String.valueOf(o);
            char eee[]=dd.toCharArray();
            int gg=Character.getNumericValue(eee[0]);
            int ff=Character.getNumericValue(eee[1]);
            if (w==o-(gg+ff)){
                arrrr.add(w);
            }
            }
            int k=0;
                for (int i = 1; i < arrrr.size(); i++) {
                    if (arrrr.get(i).equals(arrrr.get(k))){
                        arrrr.remove(i);
                    }
                    k++;
            }

        }
        return arrrr;
}
}
