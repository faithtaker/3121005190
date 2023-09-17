import org.example.Utils;
import org.junit.Test;

public class MainTest {

    String path0 = "C:\\Users\\ran\\Desktop\\myStudy\\3121005190\\work2_PaperReview\\testFile\\orig.txt";
    String path1 = "C:\\Users\\ran\\Desktop\\myStudy\\3121005190\\work2_PaperReview\\testFile\\orig.txt";
    String path2 = "C:\\Users\\ran\\Desktop\\myStudy\\3121005190\\work2_PaperReview\\testFile\\orig_0.8_add.txt";
    String path3 = "C:\\Users\\ran\\Desktop\\myStudy\\3121005190\\work2_PaperReview\\testFile\\orig_0.8_del.txt";
    String path4 = "C:\\Users\\ran\\Desktop\\myStudy\\3121005190\\work2_PaperReview\\testFile\\orig_0.8_dis_1.txt";
    String path5 = "C:\\Users\\ran\\Desktop\\myStudy\\3121005190\\work2_PaperReview\\testFile\\orig_0.8_dis_15.txt";

    @Test
    public void origOrigTest(){
        Utils.review(path0,path1);
    }

    @Test
    public void origAddTest(){
        Utils.review(path0,path2);
    }

    @Test
    public void origDelTest(){
        Utils.review(path0,path3);
    }

    @Test
    public void origDis1Test(){
        Utils.review(path0,path4);
    }

    @Test
    public void origDis10Test(){
        Utils.review(path0,path5);
    }

    @Test
    public void origDis15Test(){
        Utils.review(path0,path5);
    }

    @Test
    public void origAllTest(){
        Utils.review(path0,path1);
        Utils.review(path0,path2);
        Utils.review(path0,path3);
        Utils.review(path0,path4);
        Utils.review(path0,path5);
    }


}
