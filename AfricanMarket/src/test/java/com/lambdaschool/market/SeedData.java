package com.lambdaschool.market;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.lambdaschool.market.models.*;
import com.lambdaschool.market.services.LocationService;
import com.lambdaschool.market.services.ProductService;
import com.lambdaschool.market.services.RoleService;
import com.lambdaschool.market.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

/**
 * SeedData puts both known and random data into the database. It implements CommandLineRunner.
 * <p>
 * CoomandLineRunner: Spring Boot automatically runs the run method once and only once
 * after the application context has been loaded.
 */
@Transactional
@ConditionalOnProperty(
        prefix = "command.line.runner",
        value = "enabled",
        havingValue = "true",
        matchIfMissing = true)
@Component
public class SeedData
        implements CommandLineRunner
{
    /**
     * Connects the Role Service to this process
     */
    @Autowired
    RoleService roleService;

    /**
     * Connects the user service to this process
     */
    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    LocationService locationService;

    /**
     * Generates test, seed data for our application
     * First a set of known data is seeded into our database.
     * Second a random set of data using Java Faker is seeded into our database.
     * Note this process does not remove data from the database. So if data exists in the database
     * prior to running this process, that data remains in the database.
     *
     * @param args The parameter is required by the parent interface but is not used in this process.
     */
    @Transactional
    @Override
    public void run(String[] args) throws
            Exception
    {
        userService.deleteAll();
        roleService.deleteAll();
        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");

        r1 = roleService.save(r1);
        r2 = roleService.save(r2);
        r3 = roleService.save(r3);

        Location l1 = new Location("Burundi");
        Location l2 = new Location("Kenya");
        Location l3 = new Location("Rwanda");
        Location l4 = new Location("South Sudan");
        Location l5 = new Location("Tanzania");
        Location l6 = new Location("Uganda");

        l1 = locationService.save(l1);
        l2 = locationService.save(l2);
        l3 = locationService.save(l3);
        l4 = locationService.save(l4);
        l5 = locationService.save(l5);
        l6 = locationService.save(l6);



        Product p1 = new Product();

        p1.setName("Eggs");
        p1.setDescription("A dozen organic eggs laid by only the happiest of chickens");
        p1.setPrice(2.00);
        p1.setImageUrl("https://images.unsplash.com/photo-1585507252242-11fe632c26e8?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80");
        p1.setQuantity(1);

        productService.save(p1);

        Product p2 = new Product();

        p2.setName("Milk");
        p2.setDescription("1 Liter of organic milk squeezed out of the milkiest of cows");
        p2.setPrice(4.00);
        p2.setImageUrl("https://images.unsplash.com/photo-1528750997573-59b89d56f4f7?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1132&q=80");
        p2.setQuantity(1);

        productService.save(p2);

        Product p3 = new Product();

        p3.setName("Beef");
        p3.setDescription("2 Kilos of premium beef cut from the not so happiest of cows");
        p3.setPrice(14.00);
        p3.setImageUrl("https://images.unsplash.com/photo-1486172290186-a633e90efd68?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80");
        p3.setQuantity(1);

        productService.save(p3);

        Product p4 = new Product();

        p4.setName("Chicken");
        p4.setDescription("1 whole chicken who wasn't doing enough egg laying, take that chicken");
        p4.setPrice(10.00);
        p4.setImageUrl("https://images.unsplash.com/photo-1553161170-0c3481941f27?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1349&q=80");
        p4.setQuantity(1);

        productService.save(p4);

        Product p5 = new Product();

        p5.setName("Bacon");
        p5.setDescription("2 Kilos of thick cut bacon. Babe didn't stand a chance");
        p5.setPrice(12.00);
        p5.setImageUrl("https://images.unsplash.com/photo-1606851682837-019baf2e8da4?ixlib=rb-1.2.1&ixid=MXwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1350&q=80");
        p5.setQuantity(1);

        productService.save(p5);

        Product p6 = new Product();

        p6.setName("Beans");
        p6.setDescription("2 Kilos of Beans, beans, the musical fruit The more you eat, the more you toot The more you toot, the better you feel So let's have beans with every meal");
        p6.setPrice(4.00);
        p6.setImageUrl("https://images.unsplash.com/photo-1579705745811-a32bef7856a3?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80");
        p6.setQuantity(1);

        productService.save(p6);

        Product p7 = new Product();

        p7.setName("Rice");
        p7.setDescription("10 Kilos of brown rice. Did you know, white rice is just brown rice that's been rid of its outer bran layer and polished???");
        p7.setPrice(10.00);
        p7.setImageUrl("https://images.unsplash.com/photo-1586201375761-83865001e31c?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80");
        p7.setQuantity(1);

        productService.save(p7);

        Product p8 = new Product();

        p8.setName("Avocado");
        p8.setDescription("Idk when this started going on toast but thank you");
        p8.setPrice(3.00);
        p8.setImageUrl("https://images.unsplash.com/photo-1522687297221-2d71f8c50fd5?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80");
        p8.setQuantity(1);

        productService.save(p8);

        Product p9 = new Product();

        p9.setName("Coffee");
        p9.setDescription("2 Kilos of coffee beans, for those who chose web development as a career and need it to survive");
        p9.setPrice(5.00);
        p9.setImageUrl("https://images.unsplash.com/photo-1447933601403-0c6688de566e?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1256&q=80");
        p9.setQuantity(1);

        productService.save(p9);

        Product p10 = new Product();

        p10.setName("Cannabis");
        p10.setDescription("I was gonna write this description until I got high...cause I got high, because I got high, because I got hiigghhhh");
        p10.setPrice(10.00);
        p10.setImageUrl("https://images.unsplash.com/photo-1457573358540-3f57f7995c6c?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80");
        p10.setQuantity(1);

        productService.save(p10);


        // admin, data, user
        User u1 = new User("admin",
                "password",
                "admin@lambdaschool.local");
        u1.getRoles()
                .add(new UserRoles(u1,
                        r1));
        u1.getRoles()
                .add(new UserRoles(u1,
                        r2));
        u1.getRoles()
                .add(new UserRoles(u1,
                        r3));
        u1.getUseremails()
                .add(new Useremail(u1,
                        "admin@email.local"));
        u1.getUseremails()
                .add(new Useremail(u1,
                        "admin@mymail.local"));
        u1.getProducts()
                .add(new Product("Eggs", 2.00,"A dozen organic eggs laid by only the happiest of chickens", "https://images.unsplash.com/photo-1585507252242-11fe632c26e8?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80", 1, u1, l1));
        u1.getProducts()
                .add(new Product("Milk", 4.00,"1 Liter of organic milk squeezed out of the milkiest of cows", "https://images.unsplash.com/photo-1528750997573-59b89d56f4f7?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1132&q=80", 1, u1, l1));
        u1.getProducts()
                .add(new Product("Beef", 14.00,"2 Kilos of premium beef cut from the not so happiest of cows", "https://images.unsplash.com/photo-1486172290186-a633e90efd68?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80", 1, u1, l1));



        userService.save(u1);

        // data, user
        User u2 = new User("connie",
                "1234567",
                "connie@mail.com");
        u2.getRoles()
                .add(new UserRoles(u2,
                        r2));
        u2.getRoles()
                .add(new UserRoles(u2,
                        r3));
        u2.getUseremails()
                .add(new Useremail(u2,
                        "cinnamon@mymail.local"));
        u2.getUseremails()
                .add(new Useremail(u2,
                        "hops@mymail.local"));
        u2.getUseremails()
                .add(new Useremail(u2,
                        "bunny@email.local"));
        u2.getProducts()
                .add(new Product("Eggss", 2.00,"A dozen organic eggs laid by only the happiest of chickens", "https://images.unsplash.com/photo-1585507252242-11fe632c26e8?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80", 1, u2, l2));
        userService.save(u2);

        // user
        User u3 = new User("barnbarn",
                "ILuvM4th!",
                "barnbarn@lambdaschool.local");
        u3.getRoles()
                .add(new UserRoles(u3,
                        r2));
        u3.getUseremails()
                .add(new Useremail(u3,
                        "barnbarn@email.local"));
        u3.getProducts()
                .add(new Product("Eggsss", 2.00,"A dozen organic eggs laid by only the happiest of chickens", "https://images.unsplash.com/photo-1585507252242-11fe632c26e8?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80", 1, u3, l3));
        userService.save(u3);

        User u4 = new User("puttat",
                "password",
                "puttat@school.lambda");
        u4.getRoles()
                .add(new UserRoles(u4,
                        r2));
        u4.getProducts()
                .add(new Product("Eggssss", 2.00,"A dozen organic eggs laid by only the happiest of chickens", "https://images.unsplash.com/photo-1585507252242-11fe632c26e8?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80", 1, u4, l4));
        userService.save(u4);

        User u5 = new User("misskitty",
                "password",
                "misskitty@school.lambda");
        u5.getRoles()
                .add(new UserRoles(u5,
                        r2));
        u5.getProducts()
                .add(new Product("Eggsssssss", 2.00,"A dozen organic eggs laid by only the happiest of chickens", "https://images.unsplash.com/photo-1585507252242-11fe632c26e8?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80", 1, u5, l5));
        userService.save(u5);

        if (false)
        {
            // using JavaFaker create a bunch of regular users
            // https://www.baeldung.com/java-faker
            // https://www.baeldung.com/regular-expressions-java

            FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-US"),
                    new RandomService());
            Faker nameFaker = new Faker(new Locale("en-US"));

            for (int i = 0; i < 25; i++)
            {
                new User();
                User fakeUser;

                fakeUser = new User(nameFaker.name()
                        .username(),
                        "password",
                        nameFaker.internet()
                                .emailAddress());
                fakeUser.getRoles()
                        .add(new UserRoles(fakeUser,
                                r2));
                fakeUser.getUseremails()
                        .add(new Useremail(fakeUser,
                                fakeValuesService.bothify("????##@gmail.com")));
                userService.save(fakeUser);
            }
        }
    }
}