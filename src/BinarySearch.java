/**
 * Created by ayushij on 3/9/17.
 */
import java.util.*;
public class BinarySearch {

    public static void main(String args[]) {
        ArrayList<Integer> a = new ArrayList<>();
       /* a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(10);
        a.add(11);
        a.add(12);*/
        Integer [] arr = new Integer[]{ 2, 3, 4, 6, 9, 11, 12, 13, 14, 20, 26, 27, 28, 29, 30, 45, 47, 50, 53, 55, 57, 58, 67, 68, 69, 74, 75, 78, 86, 87, 93, 95, 99, 103, 107, 108, 114, 120, 122, 124, 128, 130, 131, 133, 134, 137, 139, 140, 143, 144, 145, 150, 151, 160, 162, 163, 167, 170, 171, 176, 183, 184, 190, 191, 193, 196, 197, 200, 201, 202, 203, 206, 207, 210, 214, 217, 218, 219, 220, 221, 223, 225, 230, 234, 237, 241, 242, 247, 249, 250, 253, 254, 260, 262, 270, 272, 279, 280, 282, 285, 287, 291, 297, 299, 300, 301, 303, 304, 305, 306, 307, 308, 312, 316, 319, 322, 325, 330, 331, 332, 335, 339, 341, 344, 346, 354, 355, 356, 358, 360, 362, 363, 365, 366, 367, 369, 371, 373, 376, 382, 383, 385, 389, 390, 396, 400, 402, 404, 405, 417, 424, 427, 430, 433, 436, 439, 444, 445, 446, 452, 453, 455, 456, 457, 460, 465, 469, 475, 476, 477, 480, 488, 489, 491, 493, 497, 499, 500, 502, 503, 507, 508, 510, 512, 513, 519, 523, 525, 528, 531, 537, 538, 541, 544, 545, 546, 548, 550, 551, 552, 556, 559, 565, 568, 569, 573, 575, 578, 583, 584, 587, 598, 599, 600, 601, 605, 608, 609, 618, 621, 623, 625, 626, 628, 629, 630, 631, 635, 639, 648, 654, 658, 660, 666, 669, 671, 674, 677, 680, 682, 685, 686, 693, 698, 700, 703, 706, 707, 708, 714, 716, 718, 720, 721, 727, 730, 737, 738, 740, 743, 745, 748, 749, 751, 752, 764, 768, 770, 771, 772, 774, 782, 784, 792, 794, 798, 799, 800, 803, 805, 806, 808, 809, 810, 811, 812, 814, 815, 818, 820, 827, 828, 830, 837, 839, 840, 841, 847, 849, 852, 856, 859, 865, 866, 867, 869, 872, 873, 875, 876, 878, 879, 880, 881, 885, 886, 891, 897, 900, 902, 903, 905, 906, 908, 910, 912, 918, 920, 921, 922, 923, 924, 925, 926, 927, 929, 930, 931, 932, 934, 941, 945, 950, 955, 957, 971, 972, 978, 984, 986, 987, 989, 993, 994};
        for (Integer item: arr) {
            a.add(item);
        }
        BinarySearch obj = new BinarySearch();
        System.out.println(obj.searchInsert(a,70));
    }

    public int searchInsert(ArrayList<Integer> a, int b) {
        System.out.println("finding " + b + " in " + a);
        int index = findElement(a, b);
        System.out.println("find gave " + index);
        if (index != -1)
            return index;
        return insertElement(a, b);
    }

    public int findElement(ArrayList<Integer> a, int b) {
        int lo = 0;
        int hi = a.size()-1;
        int mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (a.get(mid) == b)
                return mid;
            if (a.get(mid) > b) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public int insertElement(ArrayList<Integer> a, int b) {
        int lo = 0;
        int hi = a.size()-1;
        int mid;
        while (lo <= hi) {
            System.out.println("enter : lo = " + lo + " hi = " + hi);
            mid = (lo + hi) / 2;
            if (hi - lo == 1 && (a.get(lo) <= b && a.get(hi) >= b)) {
                return lo+1;
            }
            if (a.get(mid) == b)
                return mid;
            if (a.get(mid) > b) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
            System.out.println("exit: lo = " + lo + " hi = " + hi);
        }
        return lo;
    }
}

