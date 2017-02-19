package com.peace_da_ball;

import java.util.Random;

public class NumberSystems {
	
	int currentNotation = 2, futureNotation = 4, intValueFromGenerator = 0, fractValueFromGenerator = 0;	
	char[] intAnswer = new char[32], fractAnswer = new char[32];
	String answer, answerToServer = "";
	String fileName = "Notations.txt";
	Random random = new Random();
	boolean TableKey = false;
	
	public String generate(String ID) {	
		
		/*
		 * 0: 2->4
		 * 1: 2->8
		 * 2: 2->16
		 * 3: 2->10
		 * 4: 4->2
		 * 5: 8->2
		 * 6: 16->2
		 * 7: 10->N		 
		 * */
		switch(ID){
		case "0":
			GeneratorFrom_N_To_N_( 2, 4);
        	break;
		case "1":
			GeneratorFrom_N_To_N_( 2, 8);
        	break;
		case "2":
			GeneratorFrom_N_To_N_( 2, 16);
        	break;
		case "3":    	
			GeneratorFrom_N_To_N_( 2, 10);
        	break;
		case "4":	
			GeneratorFrom_N_To_N_( 4, 2);
        	break;
		case "5":
			GeneratorFrom_N_To_N_( 8, 2);			
        	break;
		case "6":
			GeneratorFrom_N_To_N_( 16, 2);
        	break;
		case "7":     
			GeneratorFrom_N_To_N_( 10, 2);
        	break;				
		default:
    		break;
		}			
			return answerToServer;
	}

	

	public float Involution(int degree, int number, int degreePositiveKey)
	{
		float value = 1;

		if (degreePositiveKey == 1)
		{
			for (int i = 0; i < degree; i++)
				value = value * number;
		}
		else
		{
			for (int i = 0; i < degree; i++)
				value = value / number;
		}
		return value;
	}
	public int DegreeOf2(int x)
	{
		int value = 1, degreeee = 0;
		for (degreeee = 0; degreeee <= 4; degreeee++){
			if (x <= value)
				return degreeee;
			else value *= 2;
		}
		return degreeee;
	}
	public int Digits(int value)
	{
		for (int digit = 1;; digit++)
		{
			value = value / 10;
			if (value == 0)
				return digit;
		}
	}
	public char ValueInHex(int value)
	{
		switch (value) {
			case 10:
				return 'A';
			case 11:
				return 'B';
			case 12:
				return 'C';
			case 13:
				return 'D';
			case 14:
				return 'E';
			case 15:
				return 'F';
			default:
				char b = Character.forDigit(value, 10);
				return b;
		}
	}


   boolean CheckingAnswer(char[] integer, char[] fractional)
    {

        //int i = 0;
        //char userkey;
        boolean mark = true;
        int strlenint = integer.length, strlenfract = fractional.length;
        int size;



        if ((answer.length()) != (strlenint + strlenfract + 1)){
            mark = false;
            return mark;
        }

        else{

            for (int counterInt = 0; counterInt < strlenint; counterInt++){
                if (answer.charAt(counterInt) != integer[counterInt])
                    mark = false;
            }

            for (int counterFract = 0; counterFract < strlenfract; counterFract++){
                if (answer.charAt(counterFract + strlenint + 1) != fractional[counterFract])
                    mark = false;
            }
        }

/*
			cout << endl << endl;

			int checkint = 0, checkfract = 0;
			bool mark = false;

			char * StringOfInt = strtok(answer, " ,.-");
			char * StringOfFract = strtok(NULL, " ,.-");

			//strtok(NULL, " ,.-");

			if ((StringOfInt == NULL) || (StringOfFract == NULL)){
			do
			{
			for (int m = 0; m < strlen(answer); m++)
			{
			answer[m] = '\0';
			}

			cout << "Введите корректный ответ : ";
			i = 0;
			while ((userkey = getch()) != 13)
			{
			cout << userkey;
			answer[i] = userkey;
			i++;
			}

			cout << endl << endl;

			StringOfInt = strtok(answer, " ,.-");
			StringOfFract = strtok(NULL, " ,.-");

			} while ((StringOfInt == NULL) || (StringOfFract == NULL));
			}

			if (strcmp(integer, StringOfInt) == 0)
			checkint = 1;

			if (strcmp(fractional, StringOfFract) == 0)
			checkfract = 1;

			if ((checkint == 1) && (checkfract == 1))
			{
			mark = true;
			cout << "Верно!" << endl;

			}
			else
			{
			cout << "Ошибка!" << endl;
			}
			*/
//
        //оценка правильности ответа

        return mark;
   }

	//ОТСТУПЫ И РАСКРАСКА
   void FromDecimalTo_N_IntSolution(int number, int FutureNotation)
    {
	  	   
        int subtrahend = 0, spaceBySubtrahend = 0, digits = 0, remainder = 0, helpRemainder = 0, space = 0, color = 1;

        while (number > 0)
        {
            for (int i = 0; i < space; i++)
            	answerToServer += " ";

            answerToServer += ("_" + number + "|" + FutureNotation + "\n");

            subtrahend = (number / FutureNotation) * FutureNotation;
            remainder = number - subtrahend;

            digits = Digits(number);
            spaceBySubtrahend = (digits - Digits(subtrahend)) * 2 + space;
            for (int i = 0; i < spaceBySubtrahend; i++)
            	answerToServer += " ";

            number /= FutureNotation;//
            answerToServer += ("  " + subtrahend + "|" + number + "\n");

            helpRemainder = remainder;
            if (remainder >= 10){
                helpRemainder = 1;
            }

            digits = spaceBySubtrahend + (Digits(subtrahend) - Digits(helpRemainder)) * 2;//

            for (int i = 0; i < digits; i++)
            	answerToServer += " ";

            if (color == 1)
            {
                //richTextBox1->SelectionColor = Color::Red;
            	answerToServer += ("  " + (ValueInHex(remainder) + "\n"));
                //richTextBox1->SelectionColor = Color::Black;
            }
            else
            if (subtrahend == 0)
            {
                //richTextBox1->SelectionColor = Color::Blue;
            	answerToServer += ("  " + (ValueInHex(remainder)));
                //richTextBox1->SelectionColor = Color::Black;
            }
            else answerToServer += ("  " + (ValueInHex(remainder) + "\n"));

            //space = digits + 2 + Digits(subtrahend / FutureNotation) + 4;
            color = 0;
        }
        answerToServer += "\n";

    }

   void FromDecimalTo_N_FractSolution(int number, int FutureNotation, int accuracy)
    {

        int  counter, degree = 0, colorKey = 0, help1 = 0, help2 = 0;
        char[] answer = new char[32];
        float Help = 0;

        degree = (int)(Involution(Digits(number), 10, 1));//

        answerToServer += ("Будем умножать дробную часть на основание: 0." + number + "*" + FutureNotation + " и записывать целую\nчасть произведения последовательно после 0. :\n\n");

        for (counter = 0; ((counter < accuracy) && (number != 0)); counter++)
        {
            help1 = (number*FutureNotation);
			help2 = help1 / degree;
            if (help2 < 10)
            	answerToServer += (" ");
            //richTextBox1->SelectionColor = Color::OrangeRed;
            answerToServer += (help2);
            //richTextBox1->SelectionColor = Color::Black;

            help1 -= help2*degree;//
            answerToServer += ("." + help1);
            answer[counter] = ValueInHex((number*FutureNotation) / degree);

            answerToServer += ("\t\t\t0.");
            colorKey ++;            
            for (int m = 0; m < colorKey; m++)
            {
                if (m == colorKey - 1)
                {
                    //richTextBox1->SelectionColor = Color::OrangeRed;
                	answerToServer += (answer[m]);
                    //richTextBox1->SelectionColor = Color::Black;
                }
               else
                	answerToServer += (answer[m]);
            }

            number = (number*FutureNotation) % degree;
            if ((counter == accuracy - 1) || (number == 0))
            	answerToServer += ("\n\n");
            else
            	answerToServer += ("\n\n");
        }        
        answerToServer += "@";
    }

   void FromDecimalTo_N_Int(int number, int FutureNotation, char[] answer)//Без нулей
    {
	   if(currentNotation == 10)
		   answerToServer += "\n"; 
	   
        int[] remainder = new int[32];
        int counter = 0;

        if (number == 0){
            answer[0] = 0;
            counter++;
        }

        while (number > 0)
        {
            remainder[counter] = number % FutureNotation;
            number /= FutureNotation;//
            counter++;
        }

        for (int i = counter; i > 0; i--){
        	if((((currentNotation == 10) || (futureNotation == 10)) && currentNotation != 2) || TableKey)
        		answerToServer += ValueInHex(remainder[i - 1]);//****
        	if(currentNotation != 10)
        		answer[counter - i]=ValueInHex(remainder[i - 1]);
        }
        if(currentNotation == 10)
        	answerToServer += ".";
        answer[counter] = '\0';
    }

   void FromDecimalTo_N_Fract(float number, int FutureNotation, int accuracy, char[] answer)
    {
        int  counter;

        for (counter = 0; ((counter < accuracy) && (number != 0)); counter++)
        {	
        	if(((currentNotation == 10) || (futureNotation == 10)) && currentNotation != 2)
        		answerToServer +=  ValueInHex((int)(number*FutureNotation));
        	if(currentNotation != 10)
        		answer[counter] = ValueInHex((int)(number*FutureNotation));
            number = (number*FutureNotation) - ((int)(number*FutureNotation));
        }
        answerToServer += "\n@";
        answer[counter] = '\0';
    }
   void FromDecimalTo_N_FractHelpPart(int number, int FutureNotation, int accuracy, char[] answer)
    {
        int  digits = 0, counter;

        digits = Digits(number);

        for (counter = 0; ((counter < accuracy) && (number != 0)); counter++)
        {
        	answerToServer +=  ValueInHex((int)((number*FutureNotation) / Involution(digits, 10, 1)));
			number = (number*FutureNotation) % (int)(Involution(digits, 10, 1));
        }
        answerToServer += "\n@";
        answer[counter] = '\0';
    }


	public void GeneratorFromDecimalTo_N_(int FutureNotation)
	{
		intValueFromGenerator = random.nextInt(150);
		fractValueFromGenerator = random.nextInt(100);
		fractAnswer[4] = '\0';
		
		if (fractValueFromGenerator % 10 == 0)
			fractValueFromGenerator++;
		answerToServer += ("Переведите число: " + intValueFromGenerator + "." + fractValueFromGenerator + "\n@");
			
		
		FromDecimalTo_N_IntSolution(intValueFromGenerator, FutureNotation);
		
		
		FromDecimalTo_N_FractSolution(fractValueFromGenerator, FutureNotation, 3);

		FromDecimalTo_N_Int(intValueFromGenerator, FutureNotation, intAnswer);
		FromDecimalTo_N_FractHelpPart(fractValueFromGenerator, FutureNotation, 3, fractAnswer);		
		
	}
	


   void Table(int CurrentNotation)
    {
	   TableKey = true;
        char[] cur = new char[32], answer = new char[5];
        int size = 0;

        for (int j = 0; j < DegreeOf2(CurrentNotation); j++)
            answer[j] = '0';

        answerToServer += ("-------------------------------------------------------------------\n");
        answerToServer += ("| Основание системы счисления: " + CurrentNotation + " ");        
        answerToServer += ("| Основание системы счисления: 2 |\n");
        answerToServer += ("-------------------------------------------------------------------\n");



        for (int i = 0; i < CurrentNotation; i++)
        {

        	answerToServer += ("               " + ValueInHex(i) + "                               ");

            FromDecimalTo_N_Int(i, 2, cur);
            size = cur.length;

            if (size == DegreeOf2(CurrentNotation))
            {
                for (int k = 0; k < DegreeOf2(CurrentNotation); k++)
                    answer[k] = cur[k];
            }
            else
            {
                for (int l = size; l > 0; l--)
                    answer[DegreeOf2(CurrentNotation) - 2] = cur[size - l];
            }

            for (int g = 0; g < 5 + DegreeOf2(CurrentNotation); g++)
            	answerToServer += ("");
            for (int y = 0; y < DegreeOf2(CurrentNotation); y++)
            	//answerToServer += ("" + answer[y]);
            for (int g = 0; g < 5 + DegreeOf2(CurrentNotation); g++)
            	answerToServer += ("");

            answerToServer += (" \n\n");

        }
        answerToServer += ("----------------------------------------------------------------------\n");
        TableKey = false;
    }

   int From_N_ToDecimalInt(char[] number, int CurrentNotation, int digitsOfNumber)
    {
        int cur = 0, Sum = 0;
        char helpString ;

        for (int i = 0; i < digitsOfNumber; i++)
        {
            switch (number[i]) {
                case 'A':
                    cur = 10;
                    break;
                case 'B':
                    cur = 11;
                    break;
                case 'C':
                    cur = 12;
                    break;
                case 'D':
                    cur = 13;
                    break;
                case 'E':
                    cur = 14;
                    break;
                case 'F':
                    cur = 15;
                    break;
                default:
                    helpString = number[i];
                    cur = Character.digit(helpString, 10);
                    break;
            }

            Sum += cur*(int)(Involution(digitsOfNumber - i - 1, CurrentNotation, 1));//
        }
        return Sum;
    }

   float From_N_ToDecimalFract(char[] number, int CurrentNotation, int digitsOfNumber)
    {
        int cur = 0;
        float Sum = 0;
        char helpString;

        for (int i = 0; i < digitsOfNumber; i++)
        {
            switch (number[i]) {
                case 'A':
                    cur = 10;
                    break;
                case 'B':
                    cur = 11;
                    break;
                case 'C':
                    cur = 12;
                    break;
                case 'D':
                    cur = 13;
                    break;
                case 'E':
                    cur = 14;
                    break;
                case 'F':
                    cur = 15;
                    break;
                default:
                    helpString = number[i];
                    cur = Character.digit(helpString, 10);
                    break;
            }
            Sum += cur*Involution(i + 1, CurrentNotation, 0);
        }
        return Sum;
    }

   void FromBinaryTo_N_Solution(int FutureNotation, char[] intValue, char[] fractValue, char[] intAnswer, char[] fractAnswer)
    {	   
        char helpString;
        int cur = 0, intSum = 0; 
                
        float fractSum = 0;

        int LengthOfInt = 0;
        int LengthOfFract = 0;            
        
        while(intValue[LengthOfInt] != '\0')
        	LengthOfInt++;
        
        while(fractValue[LengthOfFract] != '\0')
        	LengthOfFract++;
        
        int LengthOfIntAnswer = 0;
        int LengthOfFractAnswer = 0;            
        
        while(intAnswer[LengthOfIntAnswer] != '\0')
        	LengthOfIntAnswer++;
        
        while(fractAnswer[LengthOfFractAnswer] != '\0')
        	LengthOfFractAnswer++;

        int cur0 = LengthOfInt%DegreeOf2(FutureNotation);

        if (futureNotation != 10)
        {
        	answerToServer += ("Воспользуйтесь таблицей соответсвия значений цифр " + FutureNotation + "-ой системы счисления, со значениями в 2-ой системе счисления.\n\n");
            Table(FutureNotation);
            
            ///целая

            while (LengthOfInt != 0)
            {
                cur = LengthOfInt%DegreeOf2(FutureNotation);
                if (cur == 0)
                {
                    for (int i = 0; i < DegreeOf2(FutureNotation); i++)
                    	answerToServer += ("" + intValue[cur0 + i]);
                    cur0 = cur0 + DegreeOf2(FutureNotation);
                    LengthOfInt -= DegreeOf2(FutureNotation);//
                }

                else
                {
                    for (int i = 0; i < cur; i++)
                    	answerToServer += ("" + intValue[i]);
                    LengthOfInt -= cur;//
                }
                answerToServer += (" ");
            }

            answerToServer += (". ");
            /////дробная
            cur = DegreeOf2(FutureNotation);
            cur0 = 0;

            while (LengthOfFract != 0)
            {
                if (LengthOfFract < cur)
                    cur = LengthOfFract;

                for (int i = 0; i < cur; i++)
                	answerToServer += ("" + fractValue[cur0 + i]);

                LengthOfFract -= cur;//
                cur0 = cur0 + cur;
                answerToServer += (" ");
            }     
             

            answerToServer += ("=");
            for (int z = 0; z < LengthOfIntAnswer; z++){
                char a = intAnswer[z];
                answerToServer += (" " + a);
            }
            answerToServer += (" .");
            for (int z = 0; z < LengthOfFractAnswer; z++){
                char a = fractAnswer[z];
                answerToServer += (" " + a);
            }
            answerToServer += ("\n");           

        }
        
        else
        {
            //////////////// Десятичная
            //////////////// Целое
            if (futureNotation == 10){
                for (int i = 1; i <= LengthOfInt; i++)
                	answerToServer += ((LengthOfInt - i) + " ");
                answerToServer += ("\n");

                for (int i = 0; i <LengthOfInt; i++)
                	answerToServer += ("   ");
                answerToServer += (" ->");

                for (int i = 0; i < LengthOfInt; i++)
                {
                    helpString = intValue[i];
                    answerToServer += ((intValue[i]) + "*2^" + (LengthOfInt - 1 - i));
                    if (i != LengthOfInt - 1)
                    	answerToServer += ("+");
                    cur = Character.digit(helpString, 10);
                    intSum += (int)(cur*Involution(LengthOfInt - i - 1, 2, 1));//
                }

                answerToServer += (" = " + (intSum) + "\n");
                for (int i = 0; i < LengthOfInt; i++)
                	answerToServer += ((intValue[i]) + " ");
                answerToServer += ("\n\n");

                ////////////////////////////Дробное

                answerToServer += ("   ");
                for (int i = 1; i <= LengthOfFract; i++)
                	answerToServer += (((-i) + " "));
                answerToServer += ("\n");

                for (int i = 0; i <= (LengthOfFract); i++)
                	answerToServer += ("    ");
                answerToServer += ("->");

                for (int i = 0; i < LengthOfFract; i++)
                {
                    helpString = fractValue[i];
                    answerToServer += ((fractValue[i]) + "*2^" + ((-1 - i)));
                    if (i != LengthOfFract - 1)
                    	answerToServer += ("+");
                    cur = Character.digit(helpString, 10);
                    fractSum += cur*Involution(i + 1, 2, 0);//
                }
                answerToServer += (" = " + Float.toString(fractSum) + "\n");
                answerToServer += ("0. ");
                for (int i = 0; i < LengthOfFract; i++)
                	answerToServer += ((fractValue[i]) + "  ");
                answerToServer += ("\n\n");

            }
        }
        answerToServer += "@";
        
        for (int i = 0; i < LengthOfIntAnswer; i++){
        	answerToServer += intAnswer[i];
        }
        answerToServer += ".";
        for (int i = 0; i < LengthOfFractAnswer; i++){
        	answerToServer += fractAnswer[i];
        }
        answerToServer += "@";
    }   

   void From_N_ToBinarySolution (int CurrentNotation, char[] intValue, char[] fractValue){
	   
	   char[]  helpAnswer = new char[5], Answer = new char[64];
		char helpString;
       int  cur = 0, counter = 0, answercounter = 0;
       
            
           	   
       for (int j = 0; j < 5; j++)
           helpAnswer[j] = '0';
       
       int LengthOfInt = 0;
       int LengthOfFract = 0;            
       
       while(intValue[LengthOfInt] != '\0')
       	LengthOfInt++;
       
       while(fractValue[LengthOfFract] != '\0')
       	LengthOfFract++;
       
       answerToServer += ("\nВоспользуйтесь таблицей соответсвия значений цифр " + CurrentNotation + "-ой системы счисления, со значениями в 2-ой системе счисления.\n\n");
       Table(CurrentNotation);
       answerToServer += ("\n");
       
       for (int z = 0; z < LengthOfInt; z++){
           char FagsStringToChar = intValue[z];
           answerToServer += (" " + FagsStringToChar);
       }
       answerToServer += (".");
       for (int z = 0; z < LengthOfFract; z++){
           char FagsStringToChar = fractValue[z];
           answerToServer += (" " + FagsStringToChar);
       }
       answerToServer += (" = ");
       
       for (int i = 0; i < LengthOfInt; i++){
           counter = 0;
           switch (intValue[i]) {
               case 'A':
                   cur = 10;
                   break;
               case 'B':
                   cur = 11;
                   break;
               case 'C':
                   cur = 12;
                   break;
               case 'D':
                   cur = 13;
                   break;
               case 'E':
                   cur = 14;
                   break;
               case 'F':
                   cur = 15;
                   break;
               default:
                   helpString = intValue[i];
                   cur = Character.digit(helpString, 10);
                   break;
           }
           
           while (cur>0)
           {
               helpAnswer[counter] = Character.forDigit(cur % 2, 10);                 
               cur = cur / 2;
               counter++;
           }           
           
           int lengthFirst = 4;
           if(i == 0){        	  
        	   while(helpAnswer[lengthFirst] != '1'){
        		   lengthFirst --;
        	   }
        	   for(int k = lengthFirst; k >= 0; k--){
        		   answerToServer += ValueInHex(Character.digit(helpAnswer[k], 10));
        		   Answer[answercounter] = ValueInHex(Character.digit(helpAnswer[k], 10));
        		   answercounter++;	   
        	   }
        	   answerToServer += " ";
        	   
        	   for (int j = 0; j < DegreeOf2(currentNotation); j++)
                   helpAnswer[j] = '0';
           }
           else{
        	   for(int k = DegreeOf2(currentNotation) - 1; k >= 0; k--){
        		   answerToServer += ValueInHex(Character.digit(helpAnswer[k], 10));
        		   Answer[answercounter] = ValueInHex(Character.digit(helpAnswer[k], 10));
        		   answercounter++;
        	   }
        	   answerToServer += " ";
        	   for (int j = 0; j < DegreeOf2(currentNotation); j++)
                   helpAnswer[j] = '0';
           }     
           
       }
       
       Answer[answercounter] = '.';
       answercounter++;
       answerToServer += ". ";
       
       for (int i = 0; i < LengthOfFract; i++){
           counter = 0;
           switch (fractValue[i]) {
               case 'A':
                   cur = 10;
                   break;
               case 'B':
                   cur = 11;
                   break;
               case 'C':
                   cur = 12;
                   break;
               case 'D':
                   cur = 13;
                   break;
               case 'E':
                   cur = 14;
                   break;
               case 'F':
                   cur = 15;
                   break;
               default:
                   helpString = fractValue[i];
                   cur = Character.digit(helpString, 10);
                   break;
           }
           
           while (cur>0)
           {
               helpAnswer[counter] = Character.forDigit(cur % 2, 10);                 
               cur = cur / 2;
               counter++;
           }           
           
           int lengthEnd = 0;
           if(i == LengthOfFract - 1){        	  
        	   while(helpAnswer[lengthEnd] != '1'){
        		   lengthEnd ++;
        	   }
        	   for(int k = DegreeOf2(currentNotation) - 1; k >= lengthEnd; k--){
        		   answerToServer += ValueInHex(Character.digit(helpAnswer[k], 10));
        		   Answer[answercounter] = ValueInHex(Character.digit(helpAnswer[k], 10));
        		   answercounter++;
        	   }
           }
           else{
        	   for(int k = DegreeOf2(currentNotation) - 1; k >= 0; k--){
        		   answerToServer += ValueInHex(Character.digit(helpAnswer[k], 10));
        		   Answer[answercounter] = ValueInHex(Character.digit(helpAnswer[k], 10));
        		   answercounter++;
        	   }
        	   answerToServer += " ";
        	   for (int j = 0; j < DegreeOf2(currentNotation); j++)
                  helpAnswer[j] = '0';
           }       	
       }
       answerToServer += "\n@";
       answercounter = 0;
       
       while(Answer[answercounter] != '\0'){    	   
    	   answerToServer += Answer[answercounter];
    	   answercounter++;
       }
       
       answerToServer += "@";       
   }

    void GeneratorFrom_N_To_N_(int CurrentNotation, int FutureNotation)
    {
    	currentNotation = CurrentNotation;
    	futureNotation = FutureNotation;
    	answerToServer = "";
    	
        int cur;
        
        boolean mark = false;

        if (CurrentNotation != 10)
        	answerToServer += "Переведите число: ";
        

        int DigitsOfInt = 0, DigitsOfFract = 0;

        if (CurrentNotation == 10)
        {
            DigitsOfInt = (FutureNotation + 1) + random.nextInt(((int)(Involution(5, FutureNotation, 1))));
            DigitsOfFract = 2 + random.nextInt( 4);
        }

        if ((CurrentNotation == 2) && (FutureNotation != 10))
        {
            DigitsOfInt = DegreeOf2(FutureNotation) + random.nextInt(((DegreeOf2(FutureNotation) * 3) - 1));
            DigitsOfFract = DegreeOf2(FutureNotation) + random.nextInt(((DegreeOf2(FutureNotation) * 3) - 1));

        }

        if ((CurrentNotation == 2) && (FutureNotation == 10))
        {
            DigitsOfInt = 1 + random.nextInt(4);
            DigitsOfFract = 2 + random.nextInt(3);
        }

        if ((CurrentNotation == 10) && (FutureNotation == 2))
        {
            DigitsOfInt = 1 + random.nextInt(4);
            DigitsOfFract = 2 + random.nextInt(3);
        }

        if ((CurrentNotation != 10) && (CurrentNotation != 2))
        {
            DigitsOfInt = 1 + random.nextInt(3);
            DigitsOfFract = 2 + random.nextInt(3);
        }
        //======================================
        
        
        char[] Integer = new char[DigitsOfInt + 1];
        char[] Fractional = new char[DigitsOfFract + 1];
        
        
        //======================================
        
        if (CurrentNotation == 10)
            GeneratorFromDecimalTo_N_(FutureNotation);
        else{

            for (int i = 0; i < DigitsOfInt; i++)
            {
                if (i == 0)
                {
                    cur = 1 + random.nextInt((CurrentNotation - 1));
                    Integer[i] = ValueInHex(cur);
                    answerToServer += Integer[i];
                }
                else
                {
                    cur = random.nextInt((CurrentNotation));
                    Integer[i] = ValueInHex(cur);
                    answerToServer += Integer[i];
                }
            }
            Integer[DigitsOfInt] = '\0';

            answerToServer += ".";

            for (int i = 0; i < DigitsOfFract; i++)
            {
                if (i == (DigitsOfFract - 1)){
                    cur = 1 + random.nextInt((CurrentNotation - 1));
                    Fractional[i] = ValueInHex(cur);
                    answerToServer += Fractional[i];
                }
                else
                {
                    cur = random.nextInt((CurrentNotation));
                    Fractional[i] = ValueInHex(cur);
                    answerToServer += Fractional[i];
                }
            }
            Fractional[DigitsOfFract] = '\0';
           
                FromDecimalTo_N_Int(From_N_ToDecimalInt(Integer, CurrentNotation, DigitsOfInt), FutureNotation, intAnswer);
                if(((currentNotation == 10) || (futureNotation == 10)) && currentNotation != 2)
                	answerToServer += ".";
                FromDecimalTo_N_Fract(From_N_ToDecimalFract(Fractional, CurrentNotation, DigitsOfFract), FutureNotation, 12, fractAnswer);
                	
                	if(currentNotation == 2){
                		FromBinaryTo_N_Solution(FutureNotation, Integer, Fractional, intAnswer, fractAnswer);
                	}
                	else{                		
                		From_N_ToBinarySolution(CurrentNotation, Integer, Fractional);
                	}                
            }           
    }

}