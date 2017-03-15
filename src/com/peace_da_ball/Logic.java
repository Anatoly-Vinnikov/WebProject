package com.peace_da_ball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Logic {
	int[] first, secondary, save, forReverse, forExtra, sum, reverseFirst, reverseSecondary, extraFirst, extraSecondary,
    forSolution, savedForSum1, savedForSum2, directCode, reverseCode, extraCode, solForCodes1, solForCodes2;
Random rnd;
int tmp, point1, point2, newPoint1, newPoint2, newPoint3, diff1, diff2, shiftEnd, shiftStart1, shiftStart2, maxIndexToBin, counterToAns;
char isSolution;
boolean test1, test2, isCorrect, fl1, fl2, isNeg1, isNeg2, secondMax, isAnsIndexNeg, isNormalized;
ArrayList<Integer> bin1, bin2, maxIndex;

String answer, directCodeForAns, reverseCodeForAns, extraCodeForAns;

public String generate(String id) {
	bin1 = new ArrayList<Integer>();
	bin2 = new ArrayList<Integer>();
	maxIndex = new ArrayList<Integer>();
	first = new int[8];
	reverseCode = new int[8];
	extraCode = new int[8];
	solForCodes1 = new int[8];
	solForCodes2 = new int[8];
	secondary = new int[8];
	save = new int[8];
	forReverse = new int[8];
	forExtra = new int[8];
	sum = new int[8];
	reverseFirst = new int[8];
	reverseSecondary = new int[8];
	extraFirst = new int[8];
	extraSecondary = new int[8];
	forSolution = new int[8];
	savedForSum1 = new int[8];
	savedForSum2 = new int[8];
	directCode = new int[8];
	rnd = new Random();
	tmp = 0;
	test1 = false;
	test2 = false;
	isCorrect = true;
	fl1 = false;
	fl2 = false;
	isNeg1 = false;
	isNeg2 = false;	
	secondMax = false;
	isAnsIndexNeg = false;
	isNormalized = false;
	directCodeForAns = "";
	reverseCodeForAns = "";
	extraCodeForAns = "";
	
	/*for (int i = 0; i < 8; i++)
    {
        first[i] = rnd.nextInt(2);
        secondary[i] = rnd.nextInt(2);
    }*/
    testForZero();
    
    /*
     * ID's list:
     * 0 - codes from direct
     * 1 - codes from reverse
     * 2 - codes from extra
     * 3 - int sum in reverse
     * 4 - int sum in extra
     * 5 - frac sum in reverse
     * 6 - frac sum in extra
     * 7 - float sum in reverse
     * 8 - float sum in extra
     */
    
    switch (id) {
    case "0":
    	answersForCodes();
        checkForCodesFromDirect();
        answer += "@";
        solutionForCodes(1);
    	break;
    case "1":
    	answersForCodes();
        checkForCodesFromReverse();
        answer += "@";
        solutionForCodes(2);
    	break;
    case "2":
    	answersForCodes();
        checkForCodesFromExtra();
        answer += "@";
        solutionForCodes(3);
    	break;
    case "3":
    	testForSum();
        checkForIntSumInReverse();
        answer += "@";
        solutionForIntSumInReverse();    
        answer += "@";
        for (int i = 0; i < 8; i++)
        	answer += sum[i];
    	break;
    case "4":
    	testForSum();
        checkForIntSumInExtra();
        answer += "@";
        solutionForIntSumInExtra();    
        answer += "@";
        for (int i = 0; i < 8; i++)
        	answer += sum[i];
    	break;
    case "5":
    	testForSum();
    	checkForFracSumInReverse();
        answer += "@";
        solutionForFracSumInReverse();    
        answer += "@";
        for (int i = 0; i < 8; i++) {
        	answer += sum[i];
        	if (i == 0)
        		answer += '.';
        }
    	break;
    case "6":
    	testForSum();
    	checkForFracSumInExtra();
        answer += "@";
        solutionForFracSumInExtra();    
        answer += "@";
        for (int i = 0; i < 8; i++) {
        	answer += sum[i];
        	if (i == 0)
        		answer += '.';
        }
    	break;
    case "7":
    	testForSum();
    	checkForFloatSumInReverse();
        answer += "@";
        solutionForFloatSumInReverse();    
        answer += "@";
        if (newPoint3 == 0) {
            answer += "0.";
            counterToAns = 0;
        }
        else
        	counterToAns = newPoint3 - 1;
        for (int i = counterToAns; i < 8; i++)//from 0
    	{
            answer += sum[i];
    		if (i == newPoint3 - 1)
                answer += ".";
    	}
        //answer += " * 2^";
        answer += " ";
        if (isNormalized) {
        	if (isAnsIndexNeg)
                answer += "-";
        	for (int i = 0; i < maxIndex.size(); i++)
                answer += maxIndex.get(i);
            }
        else {
        	if (!secondMax) {
        		if (isNeg1)
        			answer += "-";
        		for (int i = 0; i < bin1.size(); i++)
        			answer += bin1.get(i);
        	}
        	else {
        		if (isNeg2)
        			answer += "-";
        		for (int i = 0; i < bin2.size(); i++)
        			answer += bin2.get(i);
        	}
        }
    	break;
    case "8":
    	testForSum();
    	checkForFloatSumInExtra();
        answer += "@";
        solutionForFloatSumInExtra();    
        answer += "@";
        if (newPoint3 == 0) {
            answer += "0.";
            counterToAns = 0;
        }
        else
        	counterToAns = newPoint3 - 1;
        for (int i = counterToAns; i < 8; i++)//from 0
    	{
            answer += sum[i];
    		if (i == newPoint3 - 1)
                answer += ".";
    	}
        //answer += " * 2^";
        answer += " ";
        if (isNormalized) {
        	if (isAnsIndexNeg)
                answer += "-";
        	for (int i = 0; i < maxIndex.size(); i++)
                answer += maxIndex.get(i);
            }
        else {
        	if (!secondMax) {
        		if (isNeg1)
        			answer += "-";
        		for (int i = 0; i < bin1.size(); i++)
        			answer += bin1.get(i);
        	}
        	else {
        		if (isNeg2)
        			answer += "-";
        		for (int i = 0; i < bin2.size(); i++)
        			answer += bin2.get(i);
        	}
        }
    	break;
    	default:
    		break;
    }

	return answer;
}

private void testForZero()
{
	while (!test1) {
		for (int i = 0; i < 8; i++) {
			first[i] = rnd.nextInt(2);
	        if (first[i] == 1 && !test1)
	            test1 = true;
	    }
	}
	
	while (!test2) {
		for (int i = 0; i < 8; i++) {
			secondary[i] = rnd.nextInt(2);
	        if (secondary[i] == 1 && !test2)
	            test2 = true;
	    }
	}
	/*for (int i = 0; i < 8; i++)
    {
        if (first[i] == 1 && !test1)
            test1 = true;
        if (secondary[i] == 1 && !test2)
            test2 = true;
        if (test1 && test2)
            break;
    }
    if (!test1 || !test2)
        //generate();////////////////////////////////////////////////////////*/
}

private void testForSum()
{
    if (first[0] == 0)
        test1 = true;
    else
        test1 = false;
    if (secondary[0] == 0)
        test2 = true;
    else
        test2 = false;
    if (!test1)
    {
        reverseFirst[0] = 1;
        //cout << "Число в обратном коде - ";
        for (int i = 1; i < 8; i++)
            if (first[i] == 1)
                reverseFirst[i] = 0;
            else
                reverseFirst[i] = 1;

        for (int i = 0; i < 8; i++)
            extraFirst[i] = reverseFirst[i];

        //cout << "Число в дополнительном коде - ";
        for (int i = 7; i >= 0; i--)
            if (extraFirst[i] == 0)
            {
                extraFirst[i] = 1;
                if (i < 7)
                    for (int j = i + 1; j < 8; j++)
                        extraFirst[j] = 0;
                break;
            }
    }
    else
        for (int i = 0; i < 8; i++)
        {
            reverseFirst[i] = first[i];
            extraFirst[i] = first[i];
        }

    if (!test2)
    {
        reverseSecondary[0] = 1;
        //cout << "Число в обратном коде - ";
        for (int i = 1; i < 8; i++)
            if (secondary[i] == 1)
                reverseSecondary[i] = 0;
            else
                reverseSecondary[i] = 1;

        for (int i = 0; i < 8; i++)
            extraSecondary[i] = reverseSecondary[i];

        //cout << "Число в дополнительном коде - ";
        for (int i = 7; i >= 0; i--)
            if (extraSecondary[i] == 0)
            {
                extraSecondary[i] = 1;
                if (i < 7)
                    for (int j = i + 1; j < 8; j++)
                        extraSecondary[j] = 0;
                break;
            }
    }
    else
        for (int i = 0; i < 8; i++)
        {
            reverseSecondary[i] = secondary[i];
            extraSecondary[i] = secondary[i];
        }
}

private void answersForCodes()
{
    //cout << "Исходное число - ";
    for (int i = 0; i < 8; i++) {
        directCode[i] = first[i];
        directCodeForAns += first[i];
    }
    //cout << endl;

    reverseCode[0] = first[0];

    if (first[0] == 0)
        for (int i = 0; i < 8; i++)
        {
            reverseCode[i] = first[i];
            extraCode[i] = first[i];
        }
    else
    {
        //cout << "Число в обратном коде - ";
        for (int i = 1; i < 8; i++)
            if (first[i] == 1)
                reverseCode[i] = 0;
            else
                reverseCode[i] = 1;

        for (int i = 0; i < 8; i++)
        {
            extraCode[i] = reverseCode[i];
            forReverse[i] = reverseCode[i];
            reverseCodeForAns += reverseCode[i];
        }

        //cout << "Число в дополнительном коде - ";
        for (int i = 7; i >= 0; i--)
            if (extraCode[i] == 0)
            {
                extraCode[i] = 1;
                if (i < 7)
                    for (int j = i + 1; j < 8; j++)
                        extraCode[j] = 0;
                break;
            }

        for (int i = 0; i < 8; i++) {
            forExtra[i] = extraCode[i];
            extraCodeForAns += extraCode[i];
        }
    }
}

private void solutionForCodes(int a)
{
    int[] save;
    save = new int[8];

switch (a)
{
case 1:
if (first[0] == 0)
{
	answer += "Число в обратном коде - ";
	for (int i = 0; i < 8; i++)
		answer += first[i];
	answer += "\n";
	answer += "Число в дополнительном коде - ";
	for (int i = 0; i < 8; i++)
		answer += first[i];
	answer += "\n@";
	
	for (int i = 0; i < 8; i++)
		answer += first[i];
	answer += " ";
	for (int i = 0; i < 8; i++)
		answer += first[i];
}
else
{
    answer += "Переведем число в обратный код:\n";
        for (int i = 1; i < 8; i++)
        {
            //здесь красим нужный бит
            //cout << "Текущая цифра: " << endl;
            if (first[i] == 1)
            {
                first[i] = 0;
                answer += "1 меняем на 0\n";
            }
            else
            {
                first[i] = 1;
                answer += "0 меняем на 1\n";
            }

            for (int j = 0; j < 8; j++)
                answer += first[j];
            answer += "\n";
        }

        answer += "Переведем число в дополнительный код:\n";
        for (int i = 7; i >= 0; i--)
        {
            //здесь красим нужный бит
            //cout << "Текущая цифра: " << endl;
            if (first[i] == 0)
            {
                answer += "0 меняем на 1\nОстанавливаемся, потому что дальнейших действий не требуется\n";
                first[i] = 1;
                break;
            }
            else
            {
                answer += "1 меняем на 0\n";
                first[i] = 0;
            }

            for (int j = 0; j < 8; j++)
                answer += first[j];
            answer += "\n";
        }
        answer += "@" + reverseCodeForAns + " " + extraCodeForAns;
}
break;
case 2:
if (first[0] == 0)
{
    answer += "Число в прямом коде - ";
	for (int i = 0; i < 8; i++)
        answer += first[i];
    answer += "\n";
    answer += "Число в дополнительном коде - ";
	for (int i = 0; i < 8; i++)
        answer += first[i];
	answer += "\n@";
	
	for (int i = 0; i < 8; i++)
		answer += first[i];
	answer += " ";
	for (int i = 0; i < 8; i++)
		answer += first[i];
}
else
{
    for (int i = 0; i < 8; i++)
        save[i] = forReverse[i];
    answer += "Переведем число в прямой код:\n";
    for (int i = 1; i < 8; i++)
    {
        //здесь красим нужный бит
        //cout << "Текущая цифра: " << endl;
        if (forReverse[i] == 1)
        {
            forReverse[i] = 0;
            answer += "1 меняем на 0\n";
        }
        else
        {
            forReverse[i] = 1;
            answer += "0 меняем на 1\n";
        }

        for (int j = 0; j < 8; j++)
            answer += forReverse[j];
        answer += "\n";
    }

    answer += "Переведем число в дополнительный код:\n";
    for (int i = 7; i >= 0; i--)
    {
        //здесь красим нужный бит
        //cout << "Текущая цифра: " << endl;
        if (save[i] == 0)
        {
            answer += "0 меняем на 1\nОстанавливаемся, потому что дальнейших действий не требуется\n";
            save[i] = 1;
            break;
        }
        else
        {
            answer += "1 меняем на 0\n";
            save[i] = 0;
        }

        for (int j = 0; j < 8; j++)
            answer += save[j];
        answer += "\n";
    }
    answer += "@" + directCodeForAns + " " + extraCodeForAns;
}
break;
case 3://здесь баг??
if (first[0] == 0)
{
    answer += "Число в прямом коде - ";
	for (int i = 0; i < 8; i++)
        answer += first[i];
    answer += "\n";
    answer += "Число в обратном коде - ";
	for (int i = 0; i < 8; i++)
        answer += first[i];
	answer += "\n@";
	
	for (int i = 0; i < 8; i++)
		answer += first[i];
	answer += " ";
	for (int i = 0; i < 8; i++)
		answer += first[i];
}
else
{
    answer += "Переведем число в обратный код:\n";
    for (int i = 7; i >= 0; i--)
    {
        //здесь красим нужный бит
        //cout << "Текущая цифра: " << endl;
        if (forExtra[i] == 1)
        {
            forExtra[i] = 0;
            answer += "1 меняем на 0\nОстанавливаемся, потому что дальнейших действий не требуется\n";
            break;
        }
        else
        {
            forExtra[i] = 1;
            answer += "0 меняем на 1\n";
        }

        for (int j = 0; j < 8; j++)
            answer += forExtra[j];
        answer += "\n";
    }


    answer += "Переведем число в прямой код:\n";
    for (int i = 1; i < 8; i++)
    {
        //здесь красим нужный бит
        //cout << "Текущая цифра: " << endl;
        if (forExtra[i] == 1)
        {
            forExtra[i] = 0;
            answer += "1 меняем на 0\n";
        }
        else
        {
            forExtra[i] = 1;
            answer += "0 меняем на 1\n";
        }

        for (int j = 0; j < 8; j++)
            answer += forExtra[j];
        answer += "\n";
    } 
    answer += "@" + reverseCodeForAns + " " + directCodeForAns;
}
break;
}
}

private void solutionForIntSumInReverse()
{
	char[] ans = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };

	for (int i = 0; i < 8; i++)
		sum[i] = 0;
	tmp = 0;
	for (int i = 7; i >= 0; i--)
	{
		//тут красить
		tmp += reverseFirst[i] + reverseSecondary[i];
		switch (tmp)
		{
		case 3:
			sum[i] = 1;
			ans[i] = '1';
			tmp = 1;
            answer += "Пишем 1 и переносим 1\n";
			break;
		case 2:
			sum[i] = 0;
			ans[i] = '0';
			tmp = 1;
            answer += "Пишем 0 и переносим 1\n";
			break;
		case 1:
			sum[i] = 1;
			ans[i] = '1';
			tmp = 0;
			answer += "Пишем 1 и переносим 0\n";
			break;
		case 0:
			sum[i] = 0;
			ans[i] = '0';
			tmp = 0;
			answer += "Пишем 0 и переносим 0\n";
			break;
		}

        for (int j = 0; j < 8; j++)
        	answer += reverseFirst[j];
        answer += "\n";
        for (int j = 0; j < 8; j++)
        	answer += reverseSecondary[j];
        answer += "\n";
        for (int j = 0; j < 8; j++)
        	answer += "-";
        answer += "\n";

        for (int j = 0; j < 8; j++)
			//cout << sum[i];
        	answer += ans[j];
        answer += "\n\n";
	}

	if (tmp != 0)
	{
		answer += "Прибавляем единицу к ответу, т.к. у нас произошел перенос\n";
		for (int i = 7; i >= 0; i--)
			if (sum[i] == 0)
			{
				sum[i] = 1;
				if (i < 7)
					for (int j = i + 1; j < 8; j++)
						sum[j] = 0;
				break;
			}
		for (int i = 0; i < 8; i++)
			answer += sum[i];
		answer += "\n\n";
	}
}

private void solutionForIntSumInExtra()
{	
	char[] ans = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };

	for (int i = 0; i < 8; i++)
		sum[i] = 0;
	tmp = 0;
	for (int i = 7; i >= 0; i--)
	{
		//тут красить
		tmp += extraFirst[i] + extraSecondary[i];
		switch (tmp)
		{
		case 3:
			sum[i] = 1;
			ans[i] = '1';
			tmp = 1;
            answer += "Пишем 1 и переносим 1\n";
			break;
		case 2:
			sum[i] = 0;
			ans[i] = '0';
			tmp = 1;
			answer += "Пишем 0 и переносим 1\n";
			break;
		case 1:
			sum[i] = 1;
			ans[i] = '1';
			tmp = 0;
			answer += "Пишем 1 и переносим 0\n";
			break;
		case 0:
			sum[i] = 0;
			ans[i] = '0';
			tmp = 0;
			answer += "Пишем 0 и переносим 0\n";
			break;
		}

        for (int j = 0; j < 8; j++)
        	answer += extraFirst[j];
        answer += "\n";
        for (int j = 0; j < 8; j++)
        	answer += extraSecondary[j];
        answer += "\n";
        for (int j = 0; j < 8; j++)
        	answer += "-";
        answer += "\n";

        for (int j = 0; j < 8; j++)
			//cout << sum[i];
        	answer += ans[j];
        answer += "\n\n";
	}
}


private void solutionForFracSumInReverse()
{
	char[] ans = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };

	for (int i = 0; i < 8; i++)
		sum[i] = 0;
	int j = 7;
	tmp = 0;
	for (int i = 7; i >= 0; i--, j--)
	{
		//здесь выделяем цветом
		tmp += reverseFirst[i] + reverseSecondary[i];
		switch (tmp)
		{
		case 3:
			sum[i] = 1;
			ans[i] = '1';
			tmp = 1;
			answer += "Пишем 1 и переносим 1\n";
			break;
		case 2:
			sum[i] = 0;
			ans[i] = '0';
			tmp = 1;
			answer += "Пишем 0 и переносим 1\n";
			break;
		case 1:
			sum[i] = 1;
			ans[i] = '1';
			tmp = 0;
			answer += "Пишем 1 и переносим 0\n";
			break;
		case 0:
			sum[i] = 0;
			ans[i] = '0';
			tmp = 0;
			answer += "Пишем 0 и переносим 0\n";
			break;
		}

        for (int k = 0; k < 8; k++)
		{
        	answer += reverseFirst[k];
            if (k == 0)
            	answer += '.';
		}
        answer += "\n";
        for (int k = 0; k < 8; k++)
		{
        	answer += reverseSecondary[k];
            if (k == 0)
            	answer += '.';
		}
        answer += "\n";
        for (int k = 0; k < 9; k++)
        	answer += "-";
        answer += "\n";

		if (j != 0)
			answer += " ";
        for (int k = 0; k < 8; k++)
		{
			//cout << sum[i];
        	answer += ans[k];
			if (j == 0)
			{
				answer += '.';
				j++;
			}
		}
        answer += "\n\n";
	}

	if (tmp != 0)
	{
		answer += "Прибавляем единицу к ответу, т.к. у нас произошел перенос\n";
		for (int i = 7; i >= 0; i--)
			if (sum[i] == 0)
			{
				sum[i] = 1;
				if (i < 7)
                    for (int p = i + 1; p < 8; p++)
                        sum[p] = 0;
				break;
			}
		for (int i = 0; i < 8; i++)
		{
			answer += sum[i];
			if (i == 0)
				answer += '.';
		}
		answer += "\n\n";
	}
}

private void solutionForFracSumInExtra()
{
	char[] ans = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };

	for (int i = 0; i < 8; i++)
		sum[i] = 0;
	int j = 7;
	tmp = 0;
	for (int i = 7; i >= 0; i--, j--)
	{
		//здесь выделяем цветом
		tmp += extraFirst[i] + extraSecondary[i];
		switch (tmp)
		{
		case 3:
			sum[i] = 1;
			ans[i] = '1';
			tmp = 1;
			answer += "Пишем 1 и переносим 1\n";
			break;
		case 2:
			sum[i] = 0;
			ans[i] = '0';
			tmp = 1;
			answer += "Пишем 0 и переносим 1\n";
			break;
		case 1:
			sum[i] = 1;
			ans[i] = '1';
			tmp = 0;
			answer += "Пишем 1 и переносим 0\n";
			break;
		case 0:
			sum[i] = 0;
			ans[i] = '0';
			tmp = 0;
			answer += "Пишем 0 и переносим 0\n";
			break;
		}

        for (int k = 0; k < 8; k++)
		{
        	answer += extraFirst[k];
            if (k == 0)
            	answer += '.';
		}
        answer += "\n";
        for (int k = 0; k < 8; k++)
		{
        	answer += extraSecondary[k];
            if (k == 0)
            	answer += '.';
		}
        answer += "\n";
        for (int k = 0; k < 9; k++)
        	answer += "-";
        answer += "\n";

		if (j != 0)
			answer += " ";
        for (int k = 0; k < 8; k++)
		{
			//cout << sum[i];
        	answer += ans[k];
			if (j == 0)
			{
				answer += '.';
				j++;
			}
		}
        answer += "\n\n";
	}
}


private void solutionForFloatSumInReverse()
{
	char[] ans = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };
	for (int i = 0; i < 8; i++)
		sum[i] = 0;
	answer += "Приведем числа к нормализованному виду:\n";

	//cout << "0,";
	if (newPoint1 == 0)
	{
		newPoint1++;
		for (int i = 7; i >= 0; i--)
			if (savedForSum1[i] == 1)
			{
				if (i == 7)
				{
					savedForSum1[i] = 0;
					continue;
				}
				savedForSum1[i + 1] = savedForSum1[i];
				savedForSum1[i] = 0;
			}
	}
	//cout << "0,";
	for (int i = 0; i < 8; i++)//from newPoint1 - 1
	{
		answer += savedForSum1[i];
		if (i == newPoint1 - 1)
			answer += ".";
	}
	answer += " * 2^";
	if (isNeg1)
		answer += "-";
	for (int i = 0; i < bin1.size(); i++)
		answer += bin1.get(i);
	answer += "\n";// << "0,";
	if (newPoint2 == 0)
	{
		newPoint2++;
		for (int i = 7; i >= 0; i--)
			if (savedForSum2[i] == 1)
			{
				if (i == 7)
				{
					savedForSum2[i] = 0;
					continue;
				}
				savedForSum2[i + 1] = savedForSum2[i];
				savedForSum2[i] = 0;
			}
	}
	//cout << "0,";
	for (int i = 0; i < 8; i++)//from newPoint2 - 1
	{
		answer += savedForSum2[i];
		if (i == newPoint2 - 1)
			answer += ".";
	}
	answer += " * 2^";
	if (isNeg2)
		answer += "-";
	for (int i = 0; i < bin2.size(); i++)
		answer += bin2.get(i);
	answer += "\n";

	answer += "Приравняем показатели:\n";

	for (int j = shiftStart1; j < shiftEnd; j++)
		for (int i = 7; i > newPoint1 - 1; i--)
			if (savedForSum1[i] == 1)
			{
				if (i == 7)
				{
					savedForSum1[i] = 0;
					continue;
				}
				savedForSum1[i + 1] = savedForSum1[i];
				savedForSum1[i] = 0;
			}
	for (int j = shiftStart2; j < shiftEnd; j++)
		for (int i = 7; i > newPoint2 - 1; i--)
			if (savedForSum2[i] == 1)
			{
				if (i == 7)
				{
					savedForSum2[i] = 0;
					continue;
				}
				savedForSum2[i + 1] = savedForSum2[i];
				savedForSum2[i] = 0;
			}

	//cout << "0,";
	if (newPoint1 == 0)
		answer += "0.";
	for (int i = 0; i < 8; i++)//from newPoint1 - 1
	{
		answer += savedForSum1[i];
		if (i == newPoint1 - 1)
			answer += ".";
	}
	answer += " * 2^";
	if (!secondMax)
		if (isNeg1)
		{
			answer += "-";
			for (int i = 0; i < bin1.size(); i++)
				answer += bin1.get(i);
		}
		else
			for (int i = 0; i < bin1.size(); i++)
				answer += bin1.get(i);
	else
		if (isNeg2)
		{
			answer += "-";
			for (int i = 0; i < bin2.size(); i++)
				answer += bin2.get(i);
		}
		else
			for (int i = 0; i < bin2.size(); i++)
				answer += bin2.get(i);
	answer += "\n";// << "0,";
	if (newPoint2 == 0)
		answer += "0.";
	for (int i = 0; i < 8; i++)//from newPoint2 - 1
	{
		answer += savedForSum2[i];
		if (i == newPoint2 - 1)
			answer += ".";
	}
	answer += " * 2^";
	if (!secondMax)
		if (isNeg1)
		{
			answer += "-";
			for (int i = 0; i < bin1.size(); i++)
				answer += bin1.get(i);
		}
		else
			for (int i = 0; i < bin1.size(); i++)
				answer += bin1.get(i);
	else
		if (isNeg2)
		{
			answer += "-";
			for (int i = 0; i < bin2.size(); i++)
				answer += bin2.get(i);
		}
		else
			for (int i = 0; i < bin2.size(); i++)
				answer += bin2.get(i);
	answer += "\n";

	answer += "Сложим 2 числа:\n";

	if (newPoint1 < newPoint2)
		newPoint3 = newPoint1;
	else
		newPoint3 = newPoint2;
	tmp = 0;
	int k = 7;
    for (int i = 7; i >= 0; i--, k--)//from 6 to newPoint3 - та самая точка
	{
		tmp += savedForSum1[i] + savedForSum2[i];
		switch (tmp)
		{
		case 3:
			sum[i] = 1;
			ans[i] = '1';
			tmp = 1;
			answer += "Пишем 1 и переносим 1\n";
			break;
		case 2:
			sum[i] = 0;
			ans[i] = '0';
			tmp = 1;
			answer += "Пишем 0 и переносим 1\n";
			break;
		case 1:
			sum[i] = 1;
			ans[i] = '1';
			tmp = 0;
			answer += "Пишем 1 и переносим 0\n";
			break;
		case 0:
			sum[i] = 0;
			ans[i] = '0';
			tmp = 0;
			answer += "Пишем 0 и переносим 0\n";
			break;
		}

        if (k != 0)
        	answer += ' ';
		//cout << "0,";
		if (newPoint3 == 0)
			answer += "0.";
        for (int p = 0; p < 8; p++) // newPoint3, to 7
		{
        	answer += ans[p];//sum
            if (k == newPoint3 - 1)//надо все таки найти 3 запятую - нижний показатель, было 0////i == newPoint3 - 1
			{
            	answer += ".";
                k++;//может быть ошибка
			}
		}
        answer += " * 2^";
		if (!secondMax)
			if (isNeg1)
			{
				answer += "-";
                for (int p = 0; p < bin1.size(); p++)
                	answer += bin1.get(p);
			}
			else
                for (int p = 0; p < bin1.size(); p++)
                	answer += bin1.get(p);
		else
			if (isNeg2)
			{
				answer += "-";
                for (int p = 0; p < bin2.size(); p++)
                	answer += bin2.get(p);
			}
			else
                for (int p = 0; p < bin2.size(); p++)
                	answer += bin2.get(p);
		answer += "\n";
	}

	if (tmp != 0)
	{
		answer += "Прибавляем единицу к ответу, т.к. у нас произошел перенос\n";
		for (int i = 7; i >= 0; i--)
			if (sum[i] == 0)
			{
				sum[i] = 1;
				if (i < 7)
					for (int j = i + 1; j < 8; j++)
						sum[j] = 0;
				break;
			}
		//cout << "0,";
		if (newPoint3 == 0)
			answer += "0.";
		for (int i = 0; i < 8; i++) // newPoint3, to 7
		{
			answer += sum[i];//sum
			if (i == newPoint3 - 1)//надо все таки найти 3 запятую - нижний показатель, было 0
				answer += ".";
		}
		answer += " * 2^";
		if (!secondMax)
			if (isNeg1)
			{
				answer += "-";
				for (int i = 0; i < bin1.size(); i++)
					answer += bin1.get(i);
			}
			else
				for (int i = 0; i < bin1.size(); i++)
					answer += bin1.get(i);
		else
			if (isNeg2)
			{
				answer += "-";
				for (int i = 0; i < bin2.size(); i++)
					answer += bin2.get(i);
			}
			else
				for (int i = 0; i < bin2.size(); i++)
					answer += bin2.get(i);
		answer += "\n";
	}

	///////////нормализация ответа
	if (sum[newPoint3] != 1)
	{
		isNormalized = true;
		answer += "Необходима нормализация ответа\n";
		for (int i = 0; i < 8; i++)//from newPoint3
		{
			if (sum[i] == 1)
			{
				maxIndexToBin += newPoint3 - i;
				newPoint3 = i;
				break;
			}
		}

		if (maxIndexToBin < 0)
			isAnsIndexNeg = true;

		do
		{
			//maxIndex.push_back(maxIndexToBin % 2);
            maxIndex.add(maxIndexToBin % 2);
			maxIndexToBin /= 2;
		} while (maxIndexToBin >= 1);
        Collections.reverse(maxIndex);

		//cout << "0,";
		if (newPoint3 == 0)
			answer += "0.";
		for (int i = 0; i < 8; i++) // newPoint3, to 7
		{
			answer += ans[i];//sum
			if (i == newPoint3 - 1)//надо все таки найти 3 запятую - нижний показатель, было 0
				answer += ".";
		}
		answer += " * 2^";
		if (isAnsIndexNeg)
			answer += "-";
		for (int i = 0; i < maxIndex.size(); i++)
			answer += maxIndex.get(i);
		answer += "\n";
	}
}

private void solutionForFloatSumInExtra()
{
	char[] ans = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };
	for (int i = 0; i < 8; i++)
		sum[i] = 0;
	answer += "Приведем числа к нормализованному виду:\n";

	//cout << "0,";
	if (newPoint1 == 0)
	{
		newPoint1++;
		for (int i = 7; i >= 0; i--)
			if (savedForSum1[i] == 1)
			{
				if (i == 7)
				{
					savedForSum1[i] = 0;
					continue;
				}
				savedForSum1[i + 1] = savedForSum1[i];
				savedForSum1[i] = 0;
			}
	}
	//cout << "0,";
	for (int i = 0; i < 8; i++)//from newPoint1 - 1
	{
		answer += savedForSum1[i];
		if (i == newPoint1 - 1)
			answer += ".";
	}
	answer += " * 2^";
	if (isNeg1)
		answer += "-";
	for (int i = 0; i < bin1.size(); i++)
		answer += bin1.get(i);
	answer += "\n";// << "0,";
	if (newPoint2 == 0)
	{
		newPoint2++;
		for (int i = 7; i >= 0; i--)
			if (savedForSum2[i] == 1)
			{
				if (i == 7)
				{
					savedForSum2[i] = 0;
					continue;
				}
				savedForSum2[i + 1] = savedForSum2[i];
				savedForSum2[i] = 0;
			}
	}
	//cout << "0,";
	for (int i = 0; i < 8; i++)//from newPoint2 - 1
	{
		answer += savedForSum2[i];
		if (i == newPoint2 - 1)
			answer += ".";
	}
	answer += " * 2^";
	if (isNeg2)
		answer += "-";
	for (int i = 0; i < bin2.size(); i++)
		answer += bin2.get(i);
	answer += "\n";

	answer += "Приравняем показатели:\n";

	for (int j = shiftStart1; j < shiftEnd; j++)
		for (int i = 7; i > newPoint1 - 1; i--)
			if (savedForSum1[i] == 1)
			{
				if (i == 7)
				{
					savedForSum1[i] = 0;
					continue;
				}
				savedForSum1[i + 1] = savedForSum1[i];
				savedForSum1[i] = 0;
			}
	for (int j = shiftStart2; j < shiftEnd; j++)
		for (int i = 7; i > newPoint2 - 1; i--)
			if (savedForSum2[i] == 1)
			{
				if (i == 7)
				{
					savedForSum2[i] = 0;
					continue;
				}
				savedForSum2[i + 1] = savedForSum2[i];
				savedForSum2[i] = 0;
			}

	//cout << "0,";
	if (newPoint1 == 0)
		answer += "0.";
	for (int i = 0; i < 8; i++)//from newPoint1 - 1
	{
		answer += savedForSum1[i];
		if (i == newPoint1 - 1)
			answer += ".";
	}
	answer += " * 2^";
	if (!secondMax)
		if (isNeg1)
		{
			answer += "-";
			for (int i = 0; i < bin1.size(); i++)
				answer += bin1.get(i);
		}
		else
			for (int i = 0; i < bin1.size(); i++)
				answer += bin1.get(i);
	else
		if (isNeg2)
		{
			answer += "-";
			for (int i = 0; i < bin2.size(); i++)
				answer += bin2.get(i);
		}
		else
			for (int i = 0; i < bin2.size(); i++)
				answer += bin2.get(i);
	answer += "\n";// << "0,";
	if (newPoint2 == 0)
		answer += "0.";
	for (int i = 0; i < 8; i++)//from newPoint2 - 1
	{
		answer += savedForSum2[i];
		if (i == newPoint2 - 1)
			answer += ".";
	}
	answer += " * 2^";
	if (!secondMax)
		if (isNeg1)
		{
			answer += "-";
			for (int i = 0; i < bin1.size(); i++)
				answer += bin1.get(i);
		}
		else
			for (int i = 0; i < bin1.size(); i++)
				answer += bin1.get(i);
	else
		if (isNeg2)
		{
			answer += "-";
			for (int i = 0; i < bin2.size(); i++)
				answer += bin2.get(i);
		}
		else
			for (int i = 0; i < bin2.size(); i++)
				answer += bin2.get(i);
	answer += "\n";

    answer += "Сложим 2 числа:\n";

	if (newPoint1 < newPoint2)
		newPoint3 = newPoint1;
	else
		newPoint3 = newPoint2;
	tmp = 0;
	int k = 7;
    for (int i = 7; i >= 0; i--, k--)//from 6 to newPoint3 - та самая точка
	{
		tmp += savedForSum1[i] + savedForSum2[i];
		switch (tmp)
		{
		case 3:
			sum[i] = 1;
			ans[i] = '1';
			tmp = 1;
            answer += "Пишем 1 и переносим 1\n";
			break;
		case 2:
			sum[i] = 0;
			ans[i] = '0';
			tmp = 1;
            answer += "Пишем 0 и переносим 1\n";
			break;
		case 1:
			sum[i] = 1;
			ans[i] = '1';
			tmp = 0;
            answer += "Пишем 1 и переносим 0\n";
			break;
		case 0:
			sum[i] = 0;
			ans[i] = '0';
			tmp = 0;
            answer += "Пишем 0 и переносим 0\n";
			break;
		}

        if (k != 0)
            answer += ' ';
		//cout << "0,";
		if (newPoint3 == 0)
            answer += "0.";
        for (int p = 0; p < 8; p++) // newPoint3, to 7
		{
            answer += ans[p];//sum
            if (k == newPoint3 - 1)//надо все таки найти 3 запятую - нижний показатель, было 0////i == newPoint3 - 1
			{
                answer += ".";
                k++;//может быть ошибка
			}
		}
        answer += " * 2^";
		if (!secondMax)
			if (isNeg1)
			{
                answer += "-";
                for (int p = 0; p < bin1.size(); p++)
                    answer += bin1.get(p);
			}
			else
                for (int p = 0; p < bin1.size(); p++)
                    answer += bin1.get(p);
		else
			if (isNeg2)
			{
                answer += "-";
                for (int p = 0; p < bin2.size(); p++)
                    answer += bin2.get(p);
			}
			else
                for (int p = 0; p < bin2.size(); p++)
                    answer += bin2.get(p);
        answer += "\n";
	}

	///////////нормализация ответа
	if (sum[newPoint3] != 1)
	{
		isNormalized = true;
        answer += "Необходима нормализация ответа\n";
		for (int i = 0; i < 8; i++)//from newPoint3
		{
			if (sum[i] == 1)
			{
				maxIndexToBin += newPoint3 - i;
				newPoint3 = i;
				break;
			}
		}

		do
		{
			//maxIndex.push_back(maxIndexToBin % 2);
            maxIndex.add(maxIndexToBin % 2);
			maxIndexToBin /= 2;
		} while (maxIndexToBin >= 1);
        Collections.reverse(maxIndex);

		//cout << "0,";
		if (newPoint3 == 0)
            answer += "0.";
		for (int i = 0; i < 8; i++) // newPoint3, to 7
		{
            answer += ans[i];//sum
			if (i == newPoint3 - 1)//надо все таки найти 3 запятую - нижний показатель, было 0
                answer += ".";
		}
        answer += " * 2^";
		if (isAnsIndexNeg)
            answer += "-";
		for (int i = 0; i < maxIndex.size(); i++)
            answer += maxIndex.get(i);
        answer += "\n";
	}
}


private void checkForCodesFromReverse()
{
    answer = "Число в обратном коде - ";
    for (int i = 0; i < 8; i++)
        answer += reverseCode[i];
    answer += "\n";

    answer += "Введите число в прямом и дополнительном коде через пробел.\n";
    /*for (int i = 0; i < 8; i++)
    {
        //solForCodes1[i] = _getch() - 48;
        //cout << solForCodes1[i];
    }
    answer += "\nВведите число в дополнительном коде: ";
    for (int i = 0; i < 8; i++)
    {
        //solForCodes2[i] = _getch() - 48;
        //cout << solForCodes2[i];
    }*/

    /*for (int i = 0; i < 8; i++)
    {
        if (solForCodes1[i] != directCode[i] || solForCodes2[i] != extraCode[i])
        {
            isCorrect = false;
            break;
        }
    }

    if (!isCorrect)
        answer += "\nВы допустили ошибку.\n";
    else
        answer += "\nВаш ответ правильный.\n";*/
}

private void checkForCodesFromExtra()
{
    answer = "Число в дополнительном коде - ";
    for (int i = 0; i < 8; i++)
        answer += extraCode[i];
    answer += "\n";

    answer += "Введите число в обратном и прямом коде через пробел.\n";
    /*for (int i = 0; i < 8; i++)
    {
        //solForCodes2[i] = _getch() - 48;
        //cout << solForCodes2[i];
    }
    answer += "\nВведите число в прямом коде: ";
    for (int i = 0; i < 8; i++)
    {
        //solForCodes1[i] = _getch() - 48;
        //cout << solForCodes1[i];
    }*/

    /*for (int i = 0; i < 8; i++)
    {
        if (solForCodes1[i] != directCode[i] || solForCodes2[i] != reverseCode[i])
        {
            isCorrect = false;
            break;
        }
    }

    if (!isCorrect)
        answer += "\nВы допустили ошибку.\n";
    else
        answer += "\nВаш ответ правильный.\n";*/
}

private void checkForCodesFromDirect()
{
    answer = "Число в прямом коде - ";
    for (int i = 0; i < 8; i++)
        answer += directCode[i];
    answer += "\n";

    answer += "Введите число в обратном и дополнительном коде через пробел.\n";
    /*for (int i = 0; i < 8; i++)
    {
        //здесь ввод из поля
        //solForCodes1[i] = _getch() - 48;
        //cout << solForCodes1[i];
    }
    answer += "\nВведите число в дополнительном коде: ";
    for (int i = 0; i < 8; i++)
    {
        //здесь ввод из поля
        //solForCodes2[i] = _getch() - 48;
        //cout << solForCodes2[i];
    }*/

    /*for (int i = 0; i < 8; i++)//проверка ответа
    {
        if (solForCodes1[i] != reverseCode[i] || solForCodes2[i] != extraCode[i])
        {
            isCorrect = false;
            break;
        }
    }

    if (!isCorrect)
        answer += "\nВы допустили ошибку.\n";
    else
        answer += "\nВаш ответ правильный.\n";*/
}


private void checkForIntSumInReverse()
{
/*int[] solToTest;
solToTest = new int[8];*/
answer = "Исходное выражение:\n";
for (int i = 0; i < 8; i++)
answer += reverseFirst[i];
answer += "\n";
for (int i = 0; i < 8; i++)
answer += reverseSecondary[i];
answer += "\n";

for (int i = 7; i >= 0; i--)
{
tmp += reverseFirst[i] + reverseSecondary[i];
switch (tmp)
{
case 3:
	sum[i] = 1;
	tmp = 1;
	break;
case 2:
	sum[i] = 0;
	tmp = 1;
	break;
case 1:
	sum[i] = 1;
	tmp = 0;
	break;
case 0:
	sum[i] = 0;
	tmp = 0;
	break;
}
}

if (tmp != 0)
{
//cout << "Прибавляем единицу к ответу, т.к. у нас произошел перенос" << endl;
for (int i = 7; i >= 0; i--)
	if (sum[i] == 0)
	{
		sum[i] = 1;
		if (i < 7)
			for (int j = i + 1; j < 8; j++)
				sum[j] = 0;
		break;
	}
}

answer += "Введите ответ.\n";
/*for (int i = 0; i < 8; i++)
{
//solToTest[i] = _getch() - 48;
//cout << solToTest[i];
}*/
/*for (int i = 0; i < 8; i++)
{
if (solToTest[i] != sum[i])
{
	isCorrect = false;
	break;
}
}

if (!isCorrect)
answer += "\nВы допустили ошибку.\n";
else
answer += "\nВаш ответ правильный.\n";*/
}

private void checkForIntSumInExtra()
{
/*int[] solToTest;
solToTest = new int[8];*/
answer = "Исходное выражение:\n";
for (int i = 0; i < 8; i++)
answer += extraFirst[i];
answer += "\n";
for (int i = 0; i < 8; i++)
answer += extraSecondary[i];
answer += "\n";

for (int i = 7; i >= 0; i--)
{
tmp += extraFirst[i] + extraSecondary[i];
switch (tmp)
{
case 3:
	sum[i] = 1;
	tmp = 1;
	break;
case 2:
	sum[i] = 0;
	tmp = 1;
	break;
case 1:
	sum[i] = 1;
	tmp = 0;
	break;
case 0:
	sum[i] = 0;
	tmp = 0;
	break;
}
}

answer += "Введите ответ.\n";
/*for (int i = 0; i < 8; i++)
{
//solToTest[i] = _getch() - 48;
//cout << solToTest[i];
}*/
/*for (int i = 0; i < 8; i++)
{
if (solToTest[i] != sum[i])
{
	isCorrect = false;
	break;
}
}

if (!isCorrect)
answer += "\nВы допустили ошибку.\n";
else
answer += "\nВаш ответ правильный.\n";*/
}


private void checkForFracSumInReverse()
{
/*int[] solToTest;
solToTest = new int[8];*/

reverseFirst[0] = 0;
reverseSecondary[0] = 0;

answer = "Исходное выражение:\n";
for (int i = 0; i < 8; i++)
{
answer += reverseFirst[i];
if (i == 0)
    answer += '.';
}
answer += "\n";
for (int i = 0; i < 8; i++)
{
answer += reverseSecondary[i];
if (i == 0)
    answer += '.';
}
answer += "\n";

answer += "Введите ответ.\n";
/*for (int i = 0; i < 8; i++)
{
solToTest[i] = _getch() - 48;
cout << solToTest[i];
if (i == 0)
{
	_getch();
	cout << ',';
}
}*/

for (int i = 7; i >= 0; i--)
{
tmp += reverseFirst[i] + reverseSecondary[i];
switch (tmp)
{
case 3:
	sum[i] = 1;
	tmp = 1;
	break;
case 2:
	sum[i] = 0;
	tmp = 1;
	break;
case 1:
	sum[i] = 1;
	tmp = 0;
	break;
case 0:
	sum[i] = 0;
	tmp = 0;
	break;
}
}

if (tmp != 0)
{
//cout << "Прибавляем единицу к ответу, т.к. у нас произошел перенос" << endl;
for (int i = 7; i >= 0; i--)
	if (sum[i] == 0)
	{
		sum[i] = 1;
		if (i < 7)
			for (int j = i + 1; j < 8; j++)
				sum[j] = 0;
		break;
	}
}

/*for (int i = 0; i < 8; i++)
{
if (solToTest[i] != sum[i])
{
	isCorrect = false;
	break;
}
}

if (!isCorrect)
answer += "\nВы допустили ошибку.\n";
else
answer += "\nВаш ответ правильный.\n";*/
}

private void checkForFracSumInExtra()
{
/*int[] solToTest;
solToTest = new int[8];*/

extraFirst[0] = 0;
extraSecondary[0] = 0;

answer = "Исходное выражение:\n";
for (int i = 0; i < 8; i++)
{
answer += extraFirst[i];
if (i == 0)
    answer += '.';
}
answer += "\n";
for (int i = 0; i < 8; i++)
{
answer += extraSecondary[i];
if (i == 0)
    answer += '.';
}
answer += "\n";

answer += "Введите ответ.\n";
/*for (int i = 0; i < 8; i++)
{
solToTest[i] = _getch() - 48;
cout << solToTest[i];
if (i == 0)
{
	_getch();
	cout << ',';
}
}*/

for (int i = 7; i >= 0; i--)
{
tmp += extraFirst[i] + extraSecondary[i];
switch (tmp)
{
case 3:
	sum[i] = 1;
	tmp = 1;
	break;
case 2:
	sum[i] = 0;
	tmp = 1;
	break;
case 1:
	sum[i] = 1;
	tmp = 0;
	break;
case 0:
	sum[i] = 0;
	tmp = 0;
	break;
}
}

/*for (int i = 0; i < 8; i++)
{
if (solToTest[i] != sum[i])
{
	isCorrect = false;
	break;
}
}

if (!isCorrect)
answer += "\nВы допустили ошибку.\n";
else
answer += "\nВаш ответ правильный.\n";*/
}


private void checkForFloatSumInReverse()
{
	for (int i = 0; i < 8; i++)
	{
		savedForSum1[i] = reverseFirst[i];
		savedForSum2[i] = reverseSecondary[i];
	}
	/*int[] solToTest;
    solToTest = new int[8];*/

	point1 = rnd.nextInt(5);
	point2 = rnd.nextInt(5);

	answer = "Исходное выражение:\n";
	for (int i = 0; i < 8; i++)
	{
        answer += reverseFirst[i];
		if (i == point1)
            answer += ".";
	}
    answer += " * 2^0\n";
	for (int i = 0; i < 8; i++)
	{
        answer += reverseSecondary[i];
		if (i == point2)
            answer += ".";
	}
    answer += " * 2^0\n";

    answer += "Введите мантиссу и показатель со знаком через пробел.\n";
	/*for (int i = 0; i < 8; i++)
	{
		solToTest[i] = _getch() - 48;
		cout << solToTest[i];
		if (i == 0)
		{
			_getch();
			cout << ',';
		}
	}*/

	for (int i = 0; i < 8; i++)
		if (reverseFirst[i] == 1)
		{
			newPoint1 = i;
			break;
		}
	for (int i = 0; i < 8; i++)
		if (reverseSecondary[i] == 1)
		{
			newPoint2 = i;
			break;
		}

	diff1 = point1 - newPoint1 + 1;
	diff2 = point2 - newPoint2 + 1;
	shiftStart1 = diff1;
	shiftStart2 = diff2;
	if (diff1 > diff2)
	{
		shiftEnd = diff1;
		maxIndexToBin = diff1;
	}
	else
	{
		shiftEnd = diff2;
		secondMax = true;
		maxIndexToBin = diff2;
	}
	if (diff1 < 0)
		isNeg1 = true;
	if (diff2 < 0)
		isNeg2 = true;
    diff1 = Math.abs(diff1);
    diff2 = Math.abs(diff2);

	do
	{
		//bin1.push_back(diff1 % 2);
        bin1.add(diff1 % 2);
		diff1 /= 2;
	} while (diff1 >= 1);
    Collections.reverse(bin1);

	do
	{
		//bin2.push_back(diff2 % 2);
        bin2.add(diff2 % 2);
		diff2 /= 2;
	} while (diff2 >= 1);
	Collections.reverse(bin2);

	//cout << "Приравняем показатели:" << endl;

	for (int j = shiftStart1; j < shiftEnd; j++)
		for (int i = 7; i > newPoint1 - 1; i--)
			if (reverseFirst[i] == 1)
			{
				if (i == 7)
				{
					reverseFirst[i] = 0;
					continue;
				}
				reverseFirst[i + 1] = reverseFirst[i];
				reverseFirst[i] = 0;
			}

	for (int j = shiftStart2; j < shiftEnd; j++)
		for (int i = 7; i > newPoint2 - 1; i--)
			if (reverseSecondary[i] == 1)
			{
				if (i == 7)
				{
					reverseSecondary[i] = 0;
					continue;
				}
				reverseSecondary[i + 1] = reverseSecondary[i];//сдвиг вправо
				reverseSecondary[i] = 0;
			}

	//cout << "Сложим 2 числа:" << endl;

	for (int i = 7; i >= 0; i--)
	{
		tmp += reverseFirst[i] + reverseSecondary[i];
		switch (tmp)
		{
		case 3:
			sum[i] = 1;
			tmp = 1;
			break;
		case 2:
			sum[i] = 0;
			tmp = 1;
			break;
		case 1:
			sum[i] = 1;
			tmp = 0;
			break;
		case 0:
			sum[i] = 0;
			tmp = 0;
			break;
		}
	}

	if (tmp != 0)
	{
		//cout << "Прибавляем единицу к ответу, т.к. у нас произошел перенос" << endl;
		for (int i = 7; i >= 0; i--)
			if (sum[i] == 0)
			{
				sum[i] = 1;
				if (i < 7)
					for (int j = i + 1; j < 8; j++)
						sum[j] = 0;
				break;
			}
	}

	/*for (int i = 0; i < 8; i++)
	{
		if (solToTest[i] != sum[i])
		{
			isCorrect = false;
			break;
		}
	}

	if (!isCorrect)
        answer += "\nВы допустили ошибку.\n";
	else
        answer += "\nВаш ответ правильный.\n";*/
}

private void checkForFloatSumInExtra()
{
	for (int i = 0; i < 8; i++)
	{
		savedForSum1[i] = extraFirst[i];
		savedForSum2[i] = extraSecondary[i];
	}
	/*int[] solToTest;
    solToTest = new int[8];*/

	point1 = rnd.nextInt(5);
	point2 = rnd.nextInt(5);

    answer = "Исходное выражение:\n";
	for (int i = 0; i < 8; i++)
	{
        answer += extraFirst[i];
		if (i == point1)
            answer += ".";
	}
    answer += " * 2^0\n";
	for (int i = 0; i < 8; i++)
	{
        answer += extraSecondary[i];
		if (i == point2)
            answer += ".";
	}
    answer += " * 2^0\n";

    answer += "Введите мантиссу и показатель со знаком через пробел.\n";
	/*for (int i = 0; i < 8; i++)
	{
		solToTest[i] = _getch() - 48;
		cout << solToTest[i];
		if (i == 0)
		{
			_getch();
			cout << ',';
		}
	}*/

	for (int i = 0; i < 8; i++)
		if (extraFirst[i] == 1)
		{
			newPoint1 = i;
			break;
		}
	for (int i = 0; i < 8; i++)
		if (extraSecondary[i] == 1)
		{
			newPoint2 = i;
			break;
		}

	diff1 = point1 - newPoint1 + 1;
	diff2 = point2 - newPoint2 + 1;
	shiftStart1 = diff1;
	shiftStart2 = diff2;
	if (diff1 > diff2)
	{
		shiftEnd = diff1;
		maxIndexToBin = diff1;
	}
	else
	{
		shiftEnd = diff2;
		secondMax = true;
		maxIndexToBin = diff2;
	}
	if (diff1 < 0)
		isNeg1 = true;
	if (diff2 < 0)
		isNeg2 = true;
    diff1 = Math.abs(diff1);
	diff2 = Math.abs(diff2);
	do
	{
		//bin1.push_back(diff1 % 2);
        bin1.add(diff1 % 2);
		diff1 /= 2;
	} while (diff1 >= 1);
	Collections.reverse(bin1);

	do
	{
		//bin2.push_back(diff2 % 2);
        bin2.add(diff2 % 2);
		diff2 /= 2;
	} while (diff2 >= 1);
	Collections.reverse(bin2);

			//cout << "Приравняем показатели:" << endl;

			for (int j = shiftStart1; j < shiftEnd; j++)
				for (int i = 7; i > newPoint1 - 1; i--)
					if (extraFirst[i] == 1)
					{
						if (i == 7)
						{
							extraFirst[i] = 0;
							continue;
						}
						extraFirst[i + 1] = extraFirst[i];
						extraFirst[i] = 0;
					}

	for (int j = shiftStart2; j < shiftEnd; j++)
		for (int i = 7; i > newPoint2 - 1; i--)
			if (extraSecondary[i] == 1)
			{
				if (i == 7)
				{
					extraSecondary[i] = 0;
					continue;
				}
				extraSecondary[i + 1] = extraSecondary[i];//сдвиг вправо
				extraSecondary[i] = 0;
			}

	//cout << "Сложим 2 числа:" << endl;

	for (int i = 7; i >= 0; i--)
	{
		tmp += extraFirst[i] + extraSecondary[i];
		switch (tmp)
		{
		case 3:
			sum[i] = 1;
			tmp = 1;
			break;
		case 2:
			sum[i] = 0;
			tmp = 1;
			break;
		case 1:
			sum[i] = 1;
			tmp = 0;
			break;
		case 0:
			sum[i] = 0;
			tmp = 0;
			break;
		}
	}

	/*for (int i = 0; i < 8; i++)
	{
		if (solToTest[i] != sum[i])
		{
			isCorrect = false;
			break;
		}
	}

	if (!isCorrect)
        answer += "\nВы допустили ошибку.\n";
	else
        answer += "\nВаш ответ правильный.\n";*/
}

}