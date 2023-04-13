//ask_0
// Посчитайте сколько драгоценных камней в куче обычных камней
// Пример:
// jewels = “aB”, stones = “aaaAbbbB”
// Результат в консоль ”a3B1”

package For_java_HW;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите названия драгоценных камней =  ");
        String jewels = sc.nextLine();
        System.out.print("Перечислите все камни в куче =  ");
        String stones = sc.nextLine();
        String res = findjewelsInStones(jewels, stones);
        System.out.println(res);
        sc.close();
    }
    public static String findjewelsInStones(String jewels,String stones){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < jewels.length(); i++){
            int count = 0;
            for(int j = 0; j < stones.length(); j++){
                if(jewels.charAt(i) == stones.charAt(j)){
                    count++;
                }
            }
            res.append(jewels.charAt(i)).append(count);
        }
        return res.toString();
    }
}





//Таск_1
// Вам дается строка S и целочисленный массив индексов int index[s.length].
// Напишите программу, которая перетасует символы в S таким образом,
// что символ c i-й позиции переместится на индекс index[i] в результирующей строке.
//
// Пример: s = “cba”, index = [3,2,1] result “abc”
package For_java_HW;
import java.util.Scanner;
public class Task_2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите строку =  ");
        String s = sc.nextLine();
        int[] index = new int[s.length()];
        int count = s.length();
        for (int i = 0; i < s.length(); i++) {
            index[i] = count;
            count-=1;
        }
        System.out.println(shuffle(s, index));
        sc.close();
    }
    public static String shuffle(final String s, final int[] index) {
        char[] chars = s.toCharArray();
        String res = "";
        for (int i : index)
            res += chars[i - 1];
        return res;
    }
}




//Таск_2
/*На первой строке записывается натуральное число n - количество строчек в книге. 
Затем вводится n строк - строки книги. потом вводится натуральное 
число m - количество продуктов, на которые у человека аллергия. Потом вводится 
m строк - вида "продукт1 - продукт2", где продукт1 - продукт, на который у 
человека аллергия и продукт2 - продукт, на который следует заменить продукт1. 
Гарантируется что любой продукт состоит из 1 слова. название продуктов написаны
 строчными буквами. Гарантируется, что продукты, на которые нужно выполнить замену, 
 не встречаются изначально в тексте.
Выходные данные
Замените все продукты в поваренной книге Васи и выведите их построчно на экран. 
На окончания не обращайте внимание. ВАЖНО!!! Если продукт, который следует заменить 
написан с большой буквы, то и замена тоже должна начинаться с большой буквы!
Sample Input:
2
Рецепт 1. Арахис 100гр, мороженое 200гр. Возьмите арахис и измельчите его. Посыпьте измельчённый арахис на мороженое.
Рецепт 2. Клубника 100гр, сгущенка 3кг. Смешать, есть) Радоваться жизни.
3
арахис - колбаса
клубника - вишня
сгущенка - молоко
Sample Output:
Рецепт 1. Колбаса 100гр, мороженое 200гр. Возьмите колбаса и измельчите его. 
Посыпьте измельчённый колбаса на мороженое.
Рецепт 2. Вишня 100гр, молоко 3кг. Смешать, есть) Радоваться жизни.*/

package For_java_HW;
import java.util.*;
public class  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Cp866");
        System.out.printf("Введите число строк в книге= ");
        int n = sc.nextInt();
        sc.nextLine();
        List<String> recipesList = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            System.out.printf("Введите строку=  ");
            recipesList.add(sc.nextLine());
        }
        System.out.printf("Введите число замен продуктов= ");
        int m = sc.nextInt();
        sc.nextLine();
        List<String> product_1 = new ArrayList<>(); 
        List<String> product_2 = new ArrayList<>(); 
        for (int i = 0; i < m; i ++) {
            System.out.printf("Введите продукт и его замену= ");
            String[] prods = sc.nextLine().split("-");
            product_1.add(prods[0].trim());
            product_2.add(prods[1].trim());
        }
        sc.close();
        for (int i = 0, size = product_1.size(); i < size; i ++) {
            product_1.add(product_1.get(i).substring(0, 1).toUpperCase()+product_1.get(i).substring(1));
            product_2.add(product_2.get(i).substring(0, 1).toUpperCase()+product_2.get(i).substring(1));
        }
        List<String> recipesListNew = new ArrayList<>();
        for (int i = 0; i < recipesList.size(); i ++) {
            String recipe = recipesList.get(i);
            for (int j = 0; j < product_1.size(); j ++)
                recipe = recipe.replaceAll(product_1.get(j), product_2.get(j));
            recipesListNew.add(recipe);
        }
        for (String recipe : recipesListNew)
            System.out.println(recipe);
    }
}
