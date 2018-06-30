public class ArabicConverter {

    public static String arabicToRoman(int number){
        StringBuilder romanNumber = new StringBuilder();
        int mChecker  = number/1000;
        if(mChecker>=1){
            for(int i = 0; i <mChecker ; i++){
                romanNumber.append("M");
            }
        }

        int dChecker = ((number-(mChecker*1000))/500);
        if(dChecker>=1){
            for(int i = 0 ; i<dChecker; i++){
                romanNumber.append("D");
            }
        }

        int cChecker = ((number-(mChecker*1000+dChecker*500))/100);
        if(cChecker>=1){
            for(int i = 0 ; i<cChecker ; i++){
                romanNumber.append("C");
            }
        }

        int lChecker = ((number-(mChecker*1000+dChecker*500+cChecker*100))/50);
        if(lChecker>=1){
            for(int i = 0 ; i<lChecker ; i++){
                romanNumber.append("L");
            }
        }

        int xChecker = ((number-(mChecker*1000+dChecker*500+cChecker*100+lChecker*50))/10);
        if(xChecker>=1){
            for(int i = 0 ; i<xChecker ; i++){
                romanNumber.append("X");
            }
        }

        int vChecker = ((number-(mChecker*1000+dChecker*500+cChecker*100+lChecker*50+xChecker*10))/5);
        if(vChecker>=1){
            for(int i = 0 ; i<vChecker ; i++){
                romanNumber.append("V");
            }
        }

        int iChecker = ((number-(mChecker*1000+dChecker*500+cChecker*100+lChecker*50+xChecker*10+vChecker*5))/1);
        if(iChecker>=1){
            for(int i = 0 ; i<iChecker ; i++){
                romanNumber.append("I");
            }
        }

        return romanNumber.toString();
    }

    public static int romanToArabic(String roman){
        int result = 0;
        char[] letters = roman.toCharArray();
        for(int i = 0 ; i < letters.length ; i++){

            if(i==letters.length-1){
                if(letters[i]=='I'){
                    result+=1;
                    break;
                }
                if(letters[i]=='V'){
                    result+=5;
                    break;
                }
                if(letters[i]=='X'){
                    result+=10;
                    break;
                }
                if(letters[i]=='L'){
                    result+=50;
                    break;
                }
                if(letters[i]=='C'){
                    result+=100;
                    break;
                }
                if(letters[i]=='D'){
                    result+=500;
                    break;
                }
            }
            if(letters[i]=='M'){
                result+=1000;
            }

            if(letters[i]=='C' && letters[i+1]=='M'){
                result+=900;
                i++;
            }
            else if(letters[i]=='C' && letters[i+1]=='D'){
                result+=400;
                i++;
            }
            else if(letters[i]=='D'){
                result+=500;
            }


            if(letters[i]=='X' && letters[i+1]=='C'){
                result+=90;
                i++;
            }
            else if(letters[i]=='X' && letters[i+1]=='L'){
                result+=40;
                i++;
            }
            else if(letters[i]=='C'){
                result+=100;
            }
            else if(letters[i]=='L'){
                result+=50;
            }

            if(letters[i]=='I' && letters[i+1]=='X'){
                result+=9;
                i++;
            }
            else if(letters[i]=='I' && letters[i+1]=='V'){
                result+=4;
                i++;
            }
            else if(letters[i]=='X'){
                result+=10;
            }

            if(letters[i]=='I'){
                result+=1;
            }

            if(i==(letters.length-1)){
                break;
            }

        }
        return result;
    }
}
