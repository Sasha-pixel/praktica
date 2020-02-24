package com.company;

import java.lang.String;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.print("Введите через пробел количество купюр различного номинала: 30 рублей, 100 рублей, 500 рублей, 1000 рублей \n");
        Scanner in = new Scanner(System.in);
        int n_30 = in.nextInt();
        int n_100 = in.nextInt();
        int n_500 = in.nextInt();
        int n_1000 = in.nextInt();
        int i = 0, j = 0, y = 0, e = 0, tr = 0, s = 0, ps = 0, t = 0;
        int max_sum = 30 * n_30 + 100 * n_100 + 500 * n_500 * 1000 * n_1000;

        System.out.print("Введите нужную сумму \n");
        int sum = in.nextInt();
        if (sum < 10 || sum > max_sum || sum % 10 > 0)
        {
            System.out.print("Данную сумму невозможно выдать. Обратитесь в другой банкомат.\n");
        }
        else
        {

            for (i = 0;i < n_30 + 1;i++)
            {
                for (j = 0;j < n_100 + 1;j++)
                {
                    for (y = 0;y < n_500 + 1;y++)
                    {
                        for (e = 0;e < n_1000 + 1;e++)
                        {
                            if (i * 30 + j * 100 + y * 500 + e * 1000 == sum)
                            {
                                tr=i;s=j;ps=y;t=e;
                                i=n_30+1;j=n_100+1;y=n_500+1;e=n_1000+1;sum=0;
                            }
                        }
                    }
                }
            }
            if (sum == 0)
            {
                System.out.print("Вы получите: " + t+" 1000-рублёвых купюр(ы), "+ ps+" 500-рублёвых купюр(ы), "+ s +" 100-рублёвых купюр(ы), "+ tr+" 30-рублёвых купюр(ы)." );
            }
            else
                System.out.print("Данную сумму невозможно выдать.\n");
        }

    }
}
