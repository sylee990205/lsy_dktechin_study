package jpamvcexam.mainview;

import jpamvcexam.model.vo.Book;

import javax.persistence.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

public class JPASelectBookLab {
    public static void main(String[] args) throws IOException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("emptest");
        EntityManager em = factory.createEntityManager();
        TypedQuery<Book> typedQuery;
        List<Book> bookList;
        String keep = "Y";

        while (keep.equalsIgnoreCase("Y")) {
            System.out.println("\n1. 모두 출력하기");
            System.out.println("2. 가격이 높은 순으로 출력하기");
            System.out.println("3. 20000원 이상의 도서들만 출력하기");
            System.out.println("4. id가 3번인 도서 출력하기");
            System.out.println("5. 도서명에 '자바' 또는 '스프링'을 포함하는 도서들만 출력하기");
            System.out.println("6. 분류별 도서 가격의 합을 출력하기");
            System.out.println("7. 종료");
            System.out.println("\n원하는 메뉴의 번호를 선택 : ");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int menu = Integer.parseInt(bufferedReader.readLine());

            switch (menu) {
                case 1:
                    typedQuery = em.createQuery("select b from Book b", Book.class);
                    bookList = typedQuery.getResultList();
                    bookList.stream().forEach(System.out::println);
                    break;
                case 2:
                    typedQuery = em.createQuery("select b from Book b order by b.price desc ", Book.class);
                    bookList = typedQuery.getResultList();
                    bookList.stream().forEach(System.out::println);
                    break;
                case 3:
                    typedQuery = em.createQuery("select b from Book b where b.price >= 20000", Book.class);
                    bookList = typedQuery.getResultList();
                    if (bookList.size() > 0) {
                        bookList.stream().forEach(System.out::println);
                    } else {
                        System.out.println("가격이 20000원 이상인 도서가 없습니다");
                    }
                    break;
                case 4:
                    Book b = em.find(Book.class, 3);
                    if (b != null) {
                        System.out.println(b);
                    } else {
                        System.out.println("id가 3번인 도서가 없습니다.");
                    }
                    break;
                case 5:
                    typedQuery = em.createQuery("select b from Book b where b.title like :keyword", Book.class);
                    String keyword;
                    if (new Random().nextBoolean()) {
                        keyword = "자바";
                    } else {
                        keyword = "스프링";
                    }
                    typedQuery.setParameter("keyword", "%" + keyword + "%");
                    bookList = typedQuery.getResultList();
                    if (bookList.size() > 0) {
                        bookList.stream().forEach(System.out::println);
                    } else {
                        System.out.println(keyword + "를 포함하는 도서가 없습니다.");
                    }
                    break;
                case 6:
                    Query query = em.createQuery("select b.kind, sum(b.price) from Book b group by b.kind order by b.kind");
                    List<Object[]> list = query.getResultList();
                    for (Object[] o : list
                    ) {
                        System.out.printf("분류 코드 %s\t%d\n", o[0], o[1]);
                    }
                    break;
                case 7:
                    System.out.println("프로그램을 종료합니다.");
                    keep = "N";
                    em.close();
                    factory.close();
                    break;
                default:
                    System.out.println("잘못된 숫자를 입력했습니다. 메뉴 내의 숫자를 입력해주세요.\n");
            }
        }

    }
}
