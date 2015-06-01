//package whatever;
//
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
///**
//* Created by lijc on 15/5/11.
//*/
//@RunWith(SpringJUnit4ClassRunner.class)   // 1
//@SpringApplicationConfiguration(classes = Application.class)   // 2
//@WebAppConfiguration   // 3
//public class ArticleTest {
//
////    @Autowired
////    ArticleDao articleDao;
////
////    @Autowired
////    AccountDao accountDao;
//
////    @Test
////    public void dealAccountImg() {
////        List<Account> accounts = accountDao.findAll();
////        for (Account account : accounts){
////            try {
////                String originImg = account.getOriginImg();
////
////                String imgName = (UUID.randomUUID().toString() + ".jpg").replaceAll("-","");
////
////                Thumbnails.of(new URL(originImg)).forceSize(60,60).toFile(imgName);
////
////                System.out.println("http://123.56.149.56:8080/img/" + imgName);
////
////                account.setImg("http://123.56.149.56:8080/img/" + imgName);
////
////                accountDao.save(account);
////            }catch (Exception e){
////                continue;
////            }
////
////        }
////    }
//
////    @Test
////    public void dealDate() throws Exception{
////        List<Article> articleList = articleDao.findAll();
////        for (Article article : articleList){
////            String originDate = article.getOriginDate();
////
////            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
////            Date date = sdf.parse(originDate);
////            article.setDate(date);
////
////            articleDao.save(article);
////        }
////    }
////
////    @Test
////    public void dealImg() throws Exception{
////        List<Article> articleList = articleDao.findAll();
////        for (Article article : articleList){
////            String originImg = article.getImgLink();
////
////            String largeName = (UUID.randomUUID().toString() + ".jpg").replaceAll("-","");
////            String smallName = (UUID.randomUUID().toString() + ".jpg").replaceAll("-","");
////
////            Thumbnails.of(new URL(originImg)).forceSize(702,308).toFile(largeName);
////            Thumbnails.of(new URL(originImg)).forceSize(130,130).toFile(smallName);
////            System.out.println("http://123.56.149.56:8080/img/" + largeName);
////
////            article.setLargeImg("http://123.56.149.56:8080/img/" + largeName);
////            article.setSmallImg("http://123.56.149.56:8080/img/" + smallName);
////
////            articleDao.save(article);
////        }
////    }
////
////    @Test
////    public void testDate(){
////        Date date = new Date(1427558400000L);
////        Pageable pageable = new PageRequest(0, 10, Sort.Direction.DESC, "date");
////        Page<Article> articles = articleDao.findByCategoryIdAndDateGreaterThan(1L,date,pageable);
////
////    }
//
//}
