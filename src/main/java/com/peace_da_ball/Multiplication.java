package com.peace_da_ball;

public class Multiplication {
	int SizeNum;
	int SizeAnswr;
	int Sign;
	int tmp;
	int kek;
	 int lol;
	int [] First = new int [10];
	int [] Second = new int[10];
	int [] Answer = new int[20];
	int [] OrderAnswer = new int[20];
	int [] OrderFirst = new int[8];
	int [] OrderSecond = new int[8];
	int [] result = new int[8];
	int [] order = new int[8];
	String id;
	String TheFinalAnswer;
	
 public String generate (String id){
	 kek=0;
	 /*
	     * ID's list:
	     * 0 - frac direct
	     * 1 - frac extra
	     * 2 - float
	     */
	 switch (id) {
	    case "0":
	    	DirectCodeQuestGen ();
	    	DirectCodePresent ();
	    	break;
	    case "1":
	    	AddCodeQuestGen ();
	    	AddCodePresent ();
	   	break;
	    case "2":
	    	FloatQuestGen();
	    	FloatPresent ();
	       	break;
		}
	 return TheFinalAnswer;
 }
 
 	
 
 	void to_binary_string(int n)
	{
		switch (n) {
			
		case 8:
			 order[0] = 1;
			 order[1] = 0;
			 order[2] = 0;
			 order[3] = 0;
			break;
		case 7:
			 order[0] = 1;
			 order[1] = 0;
			 order[2] = 0;
			 order[3] = 1;
			break;
		case 6:
			 order[0] = 1;
			 order[1] = 0;
			 order[2] = 1;
			 order[3] = 0;
			break;
		case 5:
			 order[0] = 1;
			 order[1] = 0;
			 order[2] = 1;
			 order[3] = 1;
			break;
		case 4:
			 order[0] = 1;
			 order[1] = 1;
			 order[2] = 0;
			 order[3] = 0;
			break;
		case 3:
			 order[0] = 1;
			 order[1] = 1;
			 order[2] = 0;
			 order[3] = 1;
			break;
		case 2:
			 order[0] = 1;
			 order[1] = 1;
			 order[2] = 1;
			 order[3] = 0;
			break;
		case 1:
			 order[0] = 1;
			 order[1] = 1;
			 order[2] = 1;
			 order[3] = 1;
			break;
		}
		
		
	}
 
	public void Summation() {
		tmp = 0;
		for (int i = SizeNum - 1; i >= 0; i--) {
			tmp += First[i] + Answer[i];
			switch (tmp) {
			case 3:
				Answer[i] = 1;
				tmp = 1;
				break;
			case 2:
				Answer[i] = 0;
				tmp = 1;
				break;
			case 1:
				Answer[i] = 1;
				tmp = 0;
				break;
			case 0:
				Answer[i] = 0;
				tmp = 0;
				break;
			}
		}
	}
	public void OffsetDirectCodeAndShow() {
		for (int a = SizeAnswr - 1; a >= 0; a--) {
			if (Answer[a] == 1) {
					Answer[a + 1] = Answer[a];
					Answer[a] = 0;
			}
		}

TheFinalAnswer+=("       " +Answer[1] + ".");

		for (int i = 2; i < SizeAnswr; i++){
	TheFinalAnswer+=(Answer[i]);
		}
	}
	public void ShowSolutionsHeading() {
TheFinalAnswer+=("\n       " + First[1] + ".");
		for (int i = 2; i < SizeNum; i++) {
	TheFinalAnswer+=(First[i]);
		}

TheFinalAnswer+=("\n    *  " +Second[1] + ".");

		for (int i = 2; i < SizeNum; i++){
	TheFinalAnswer+=(Second[i]);
		}
		for (int i = 0; i < SizeNum + 3; i++){
	TheFinalAnswer+=(" ");
		}
		
TheFinalAnswer+=("\n       0.");
		for (int i = 2; i < SizeAnswr; i++) {
	TheFinalAnswer+=("0");
		}
		
TheFinalAnswer+=("   ---   исходное значение суммы частичных произведений\n");
	}

	public void DirectGenerate() {
		
		SizeNum=(int) Math.round((Math.random() * 4)+6);
		SizeAnswr = SizeNum * 2;

		First[0] = 0;
		Second[0] = 0;
		
		for (int i = 1; i<SizeNum; i++) {
			First[i] = (int) Math.round((Math.random() * 1));
		}

		for (int i = 1; i<SizeNum; i++) {
			Second[i] = (int) Math.round((Math.random() * 1));
		}

		for (int i = 0; i < SizeAnswr; i++) {
			Answer[i] = 0;
		}
	}	
	public void FloatGenerate() {
		
		 OrderFirst[0] = 0;
			
			for (int i = 1; i < 4; i++) {	
				OrderFirst[i] =  (int) Math.round((Math.random() * 1));
			}

			OrderSecond[0] = 0;
			
			for (int i = 1; i < 4; i++) {
				OrderSecond[i] = (int) Math.round((Math.random() * 1));
			}
		}
	
	public void DirectCodeQuestGen (){
		DirectGenerate();
		TheFinalAnswer=("Заданы два числа: " + First[1] + ".");

		 for (int i = 2; i < SizeNum; i++) {
			 TheFinalAnswer+=(First[i]);
		 }
		
		 TheFinalAnswer+=(" и " +Second[1]+ ".");

		 for (int i = 2; i < SizeNum; i++) {
			 TheFinalAnswer+=(Second[i]);
		 }
		 TheFinalAnswer+=(". Требуется найти их произведение в прямом коде. @ \n ");
	}
	public void DirectCodePresent (){
		if (First[1] == Second[1]) {
			 Sign = 0;
		} else {
			 Sign = 1;
			}

		 First[1] = 0;
		 Second[1] = 0;

		 ShowSolutionsHeading();

		 for (int Digit = SizeNum - 1; Digit > 0; Digit--) {
			 if (Second[Digit] == 1) {
				 TheFinalAnswer+=("     + "+First[1] + ".");

					for (int i = 2; i < SizeNum; i++) {
				TheFinalAnswer+=(First[i]);
					}

					for (int i = 0; i < SizeNum + 4; i++) {
				TheFinalAnswer+=(" ");
					}
			TheFinalAnswer+=("     текущий разряд  ");

					for (int k = 1; k <SizeNum; k++) {
						if (k == Digit) {
					TheFinalAnswer+=("["+Second[k]+"] ");
							
						}	else {
					TheFinalAnswer+=(Second[k] + " ");
						}
					}
					Summation();

			}	else {
		TheFinalAnswer+=("     + 0.");
				for (int i = 2; i < SizeAnswr; i++){
			TheFinalAnswer+=("0");
				}
			TheFinalAnswer+=("  текущий разряд  ");

					for (int k = 1; k <SizeNum; k++) {
						if (k == Digit) {
					TheFinalAnswer+=("[" + Second[k]+ "] ");
								
						}	else {
					TheFinalAnswer+=(Second[k] + " ");
						}
					}
				}
			 
			 TheFinalAnswer+=("\n     = "+ Answer[1] + ".");

				for (int i = 2; i < SizeAnswr; i++){
			TheFinalAnswer+=(Answer[i]);
				}
				TheFinalAnswer+=("   ---   сумма частичных произведений\n");

			 OffsetDirectCodeAndShow();

			 TheFinalAnswer+=("  >>>  сдвиг на 1 разряд суммы частич. произ.\n");
		 }
		 OffsetDirectCodeAndShow();
		 
		 TheFinalAnswer+=("  >>>  доп. сдвиг на 1 разряд для постановки в 2n разрядность\n\nОтвет: ");

		 Answer[1] = Sign;

		 TheFinalAnswer+=(Answer[1] + ".");

			for (int i = 2; i < SizeAnswr; i++){
		TheFinalAnswer+=(Answer[i]);
			}
			TheFinalAnswer+=("\n@"+Answer[2]+".");
			for (int i = 3; i < SizeAnswr; i++){
				TheFinalAnswer+=(Answer[i]);
					}
			
		 for (int i = 0; i < SizeAnswr; i++) {
			 Answer[i] = 0;
		 }
	}
	
	public void AddCodeQuestGen (){
		
		DirectGenerate();
		
		TheFinalAnswer=("Заданы два числа: " + First[1] + ".");

		 for (int i = 2; i < SizeNum; i++) {
			 TheFinalAnswer+=(First[i]);
		 }
		
		 TheFinalAnswer+=(" и " +Second[1]+ ".");

		 for (int i = 2; i < SizeNum; i++) {
			 TheFinalAnswer+=(Second[i]);
		 }
		 TheFinalAnswer+=(". Требуется найти их произведение в  коде. @ \n ");
	}
	public void AddCodePresent (){
		ShowSolutionsHeading();

		 for (int Digit = SizeNum - 1; Digit > 1; Digit--) {
			 if (Second[Digit] == 1) {
				 TheFinalAnswer+=("     + ");
				 TheFinalAnswer+=(First[1] + ".");

					for (int i = 2; i < SizeNum; i++) {
						TheFinalAnswer+=(First[i]);
					}

					for (int i = 0; i < SizeNum + 4; i++) {
						TheFinalAnswer+=(" ");
					}

					TheFinalAnswer+=("     текущий разряд  ");

					for (int k = 1; k < SizeNum; k++) {
						if (k == Digit) {
								
							TheFinalAnswer+=("["+Second[k]+"]");
								
								TheFinalAnswer+=(" ");
								
						}	else {
							TheFinalAnswer+=(Second[k] + " ");
						}
					}
					Summation();

			}	else {
				TheFinalAnswer+=("     + ");
				TheFinalAnswer+=("0.");
				for (int i = 2; i < SizeAnswr; i++){
					TheFinalAnswer+=("0");
				}
					TheFinalAnswer+=("  текущий разряд  ");

					for (int k = 1; k < SizeNum; k++) {
						if (k == Digit) {
								
							TheFinalAnswer+=("["+Second[k]+"]");
								
								TheFinalAnswer+=(" ");
								
						}	else {
							TheFinalAnswer+=(Second[k] + " ");
						}
				}
			}
			 if (Answer[0] == 1) {
				 TheFinalAnswer+=("\n     ="+ Answer[0]+Answer[1] + ".");

				 for (int i = 2; i < SizeAnswr; i++) {
					 TheFinalAnswer+=(Answer[i]);
				 }
				 TheFinalAnswer+=("  ---   сумма частичных произведений\n");

			 }
			 else {
				 TheFinalAnswer+=("\n     = ");
				 TheFinalAnswer+=(Answer[1] + ".");

					for (int i = 2; i < SizeAnswr; i++){
						TheFinalAnswer+=(Answer[i]);
					}
				 TheFinalAnswer+=("  ----  сумма частичных произведений\n");
			 }

			 for (int j =  SizeAnswr - 1; j >1; j--) {
					if ( Answer[j] == 1) {
							 Answer[j + 1] =  Answer[j];
							 Answer[j] = 0;
					}
				}

				if ( Answer[0] == 1) {
						 Answer[1] = 1;
						 Answer[0] = 0;
				}	else {
						if ( Answer[1] == 1) {
								 Answer[2] = 1;
								 Answer[1] = 1;
						}	else {
							 Answer[2] = 0;
							}
					}
				TheFinalAnswer+=("       ");
				TheFinalAnswer+=(Answer[1] + ".");

				for (int i = 2; i < SizeAnswr; i++){
					TheFinalAnswer+=(Answer[i]);
				}

			 TheFinalAnswer+=("  >>> сдвиг на 1 разряд суммы частич. произ.\n");
		 }

		 for (int j =  SizeAnswr - 1; j >1; j--) {
				if ( Answer[j] == 1) {
						 Answer[j + 1] =  Answer[j];
						 Answer[j] = 0;
				}
			}

			if ( Answer[0] == 1) {
					 Answer[1] = 1;
					 Answer[0] = 0;
			}	else {
					if ( Answer[1] == 1) {
							 Answer[2] = 1;
							 Answer[1] = 1;
					}	else {
						 Answer[2] = 0;
						}
				}
			TheFinalAnswer+=("       ");
			TheFinalAnswer+=(Answer[1] + ".");

			for (int i = 2; i < SizeAnswr; i++){
				TheFinalAnswer+=(Answer[i]);
			}

		 TheFinalAnswer+=("  >>>  доп. сдвиг на 1 разряд для постановки в двойную разрядность\n\nОтвет: ");
		 TheFinalAnswer+=(Answer[1] + ".");

			for (int i = 2; i < SizeAnswr; i++){
				TheFinalAnswer+=(Answer[i]);
			}
			TheFinalAnswer+=("\n@"+Answer[2]+".");

			for (int i = 3; i < SizeAnswr; i++){
				TheFinalAnswer+=(Answer[i]);
			}
			for (int i = 0; i < SizeAnswr; i++) {
				 Answer[i] = 0;
			 }
		 }
		 
	public void FloatQuestGen(){
		DirectGenerate();
		FloatGenerate();
		TheFinalAnswer=("Заданы два числа:\n" + "Мантисса = " +(First[1]) + ".");

		 for (int i = 2; i < SizeNum; i++) {
			 TheFinalAnswer+=(First[i]);
		 }
		 TheFinalAnswer+=("; Порядок = ");
		 for (int i = 0; i < 4; i++) {
			 TheFinalAnswer+= (OrderFirst[i]);
		 }
		
		 TheFinalAnswer+=("\nМантисса =  " + Second[1] + ".");

		 for (int i = 2; i < SizeNum; i++) {
			 TheFinalAnswer+=(Second[i]);
		 }

		 TheFinalAnswer+=("; Порядок = ");
		 for (int i = 0; i < 4; i++) {
			 TheFinalAnswer+=(OrderSecond[i]);
		 }

		 TheFinalAnswer+=("\nТребуется найти их произведение в прямом коде. @ \n\n");
	}
	public void FloatPresent(){
		TheFinalAnswer+=("1. Проверяем мантиссы на равенство нулю.");
		 
		 for (int i = 2; i <  SizeNum; i++) {
			 if ( Second[i] == 0)
				 kek++;
		 }
		 if (kek ==  SizeNum - 2){
			 TheFinalAnswer+=(" Одна из мантисс равна нулю. Следовательно результат нулевой.");
		 }	else {
			 TheFinalAnswer+=(" Ни одна из мантисс не равна нулю. Переходим к следующему этапу.\n\n");
			 TheFinalAnswer+=("2. Произведем умножение мантисс.\n");

			 if ( First[1] ==  Second[1]) {
				  Sign = 0;
			 } else {
				  Sign = 1;
			 }

			  First[1] = 0;
			  Second[1] = 0;

			 ShowSolutionsHeading();

			 for (int Digit =  SizeNum - 1; Digit > 0; Digit--) {
				 if (Second[Digit] == 1) {
					 TheFinalAnswer+=("     + ");
					 TheFinalAnswer+=(First[1] + ".");

						for (int i = 2; i < SizeNum; i++) {
							TheFinalAnswer+=(First[i]);
						}

						for (int i = 0; i < SizeNum + 4; i++) {
							TheFinalAnswer+=(" ");
						};
						TheFinalAnswer+=("     текущий разряд  ");

						for (int k = 1; k < SizeNum; k++) {
							if (k == Digit) {
								
									TheFinalAnswer+=(Second[k]);
								
									TheFinalAnswer+=(" ");
									
							}	else {
								TheFinalAnswer+=(Second[k] + " ");
							}
						}
						Summation();

				}	else {
					TheFinalAnswer+=("     + ");
					TheFinalAnswer+=("0.");
					for (int i = 2; i < SizeAnswr; i++){
						TheFinalAnswer+=("0");
					}
						TheFinalAnswer+=("  текущий разряд  ");

						for (int k = 1; k < SizeNum; k++) {
							if (k == Digit) {
								
									TheFinalAnswer+=(Second[k]);
								
									TheFinalAnswer+=(" ");
									
							}	else {
								TheFinalAnswer+=(Second[k] + " ");
							}
						}
					}
				 TheFinalAnswer+=("\n       ");
				 TheFinalAnswer+=(Answer[1] + ".");

					for (int i = 2; i < SizeAnswr; i++){
						TheFinalAnswer+=(Answer[i]);
					}
				 TheFinalAnswer+=("   ---   сумма частичных произведений\n");

				 OffsetDirectCodeAndShow();//1.Проводится смещение на 1 разряд и вывод числа

				 TheFinalAnswer+=("  >>>  сдвиг на 1 разряд суммы частич. произ.\n");
			 }
			 OffsetDirectCodeAndShow();//2.Проводится дополнительно смещение на 1 разряд и вывод числа

			 TheFinalAnswer+=("  >>>  доп. сдвиг на 1 разряд для постановки в 2n разрядность\n");

			  Answer[1] =  Sign;//Устанавливается знак для ответа

			 
			 int p;
			
			 
			 
			 for (p = 2;  Answer[p] != 1; p++){
				 if ( Answer[p] == 0)	{
					 lol++;
				 }
			 }
				 TheFinalAnswer+=("\nИмеет место нарушение нормализации вправо. Кол-во значащих разрядов равных нулю - "+ lol+". ");
				 TheFinalAnswer+=("Поэтому сдвинем мантиссу на это кол-во разрядов влево. А далее значение порядка уменьшим на столько же единиц. ");
				 TheFinalAnswer+=("Также установим знак произведения мантисс.\n\n");
				 for (int r = 0; r<lol; r++){
					 for (int a = 1; a <  SizeAnswr; a++) {
						 if ( Answer[a] == 1) {
							  Answer[a - 1] =  Answer[a];
							  Answer[a] = 0;
						 }
					 }
				 }
				 TheFinalAnswer+=("    Мантисса рез. = ");
				 TheFinalAnswer+=(Answer[1] + ".");

					for (int i = 2; i < SizeAnswr; i++){
						TheFinalAnswer+=(Answer[i]);
					}
				 TheFinalAnswer+=("\n\n3. Производим суммирование порядков\n");
				 ///суммирование
				 tmp = 0;
				 for (int i = 3; i >= 0; i--) {
					 tmp +=  OrderFirst[i] +  OrderSecond[i];
					 switch (tmp) {
					 case 3:
						  OrderAnswer[i] = 1;
						 tmp = 1;
						 break;
					 case 2:
						  OrderAnswer[i] = 0;
						 tmp = 1;
						 break;
					 case 1:
						  OrderAnswer[i] = 1;
						 tmp = 0;
						 break;
					 case 0:
						  OrderAnswer[i] = 0;
						 tmp = 0;
						 break;
					 }
				 }

				 ////вывод суммирования порядков
				 TheFinalAnswer+=("\n     ");
				 for (int i = 0; i < 4; i++){
					 TheFinalAnswer+=( OrderFirst[i]);
				 }
				 TheFinalAnswer+=("\n   + ");

				 
				 for (int i = 0; i<4; i++){
					 TheFinalAnswer+=( OrderSecond[i]);
				 }
				
				 TheFinalAnswer+=("\n     ");
				 for (int i = 0; i < 4; i++){
					 TheFinalAnswer+=( OrderAnswer[i]);
				 }

				 //////анализ на переполнение

				 TheFinalAnswer+=("\n\nВычтем из порядка число " + lol + " в связи с ранее проводимой нормализацией. Для этого прибавим -" + lol + " в доп. коде.\n     ");
				
				 to_binary_string(lol);

				 for (int i = 0; i < 4; i++){
					 TheFinalAnswer+=( OrderAnswer[i]);
				 }
				 TheFinalAnswer+=("\n +   ");

				 
				 for (int i = 0; i<4; i++){
					 TheFinalAnswer+=(  order[i]);
				 }
			
				//////////начинается суммирование
				 tmp = 0;
				 for (int i = 3; i >= 0; i--) {
					 tmp +=  order[i] +  OrderAnswer[i];
					 switch (tmp) {
					 case 3:
						  OrderAnswer[i] = 1;
						 tmp = 1;
						 break;
					 case 2:
						  OrderAnswer[i] = 0;
						 tmp = 1;
						 break;
					 case 1:
						  OrderAnswer[i] = 1;
						 tmp = 0;
						 break;
					 case 0:
						  OrderAnswer[i] = 0;
						 tmp = 0;
						 break;
					 }
				 }
				 TheFinalAnswer+=("\n     ");
				 for (int i = 0; i < 4; i++){
					 TheFinalAnswer+=( OrderAnswer[i]);
				 }
				 TheFinalAnswer+=("\nОтвет: ");
				 
				 TheFinalAnswer+=("	Мантисса рез. = ");
				 TheFinalAnswer+=(Answer[1] + ".");

					for (int i = 2; i < SizeAnswr; i++){
						TheFinalAnswer+=(Answer[i]);
					}

				 TheFinalAnswer+=("	Порядок рез = ");


				 for (int i = 0; i < 4; i++){
					 TheFinalAnswer+=( OrderAnswer[i]);
				 }

				 TheFinalAnswer += "\n@";
				 TheFinalAnswer+=(Answer[1] + ".");
				 
				 for (int i = 2; i < SizeAnswr; i++){
					 TheFinalAnswer+=(Answer[i]);
				 }
				 TheFinalAnswer += " ";
				 for (int i = 0; i < 4; i++){
					 TheFinalAnswer+=( OrderAnswer[i]);
				 }

			 for (int i = 0; i <  SizeAnswr; i++) {
				  Answer[i] = 0;
			 }
		 }
	}
}