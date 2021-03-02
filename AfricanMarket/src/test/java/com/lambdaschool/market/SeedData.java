package com.lambdaschool.market;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.lambdaschool.market.models.*;
import com.lambdaschool.market.services.*;
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

    @Autowired
    CategoryService categoryService;

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
        Role r2 = new Role("seller");
        Role r3 = new Role("buyer");

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

        Category c1 = new Category("meat");
        Category c2 = new Category("vegetables");
        Category c3 = new Category("fruit");

        c1 = categoryService.save(c1);
        c2 = categoryService.save(c2);
        c3 = categoryService.save(c3);




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

        u1 = userService.save(u1);

        // data, user
        User u2 = new User("mike",
                "password",
                "mike@mail.com");
        u2.getRoles()
                .add(new UserRoles(u2,
                        r2));
        u2.getRoles()
                .add(new UserRoles(u2,
                        r3));

        u2 = userService.save(u2);

        // user
        User u3 = new User("connie",
                "password",
                "connie@maill.com");
        u3.getRoles()
                .add(new UserRoles(u3,
                        r2));

        u3 = userService.save(u3);

        User u4 = new User("weston",
                "password",
                "weston@mail.com");
        u4.getRoles()
                .add(new UserRoles(u4,
                        r2));

        u4 = userService.save(u4);

        User u5 = new User("james",
                "password",
                "james@mail.com");
        u5.getRoles()
                .add(new UserRoles(u5,
                        r2));

        u5 = userService.save(u5);

        User u6 = new User("buyer",
                "password",
                "buyer@mail.com");
        u6.getRoles()
                .add(new UserRoles(u6,
                        r3));

        u6 = userService.save(u6);

        Product p1 = new Product();

        p1.setName("Eggs");
        p1.setDescription("A dozen organic eggs laid by only the happiest of chickens!");
        p1.setPrice(2.00);
        p1.setImageUrl("https://images.unsplash.com/photo-1585507252242-11fe632c26e8?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80");
        p1.setQuantity(1);
        p1.setUser(u1);
        p1.setLocation(l1);
        p1.setCategory(c1);

        productService.save(p1);

        Product p2 = new Product();
//
        p2.setName("Carrots");
        p2.setDescription("2 Kilos of organic carrots, the Bugs Bunny special!");
        p2.setPrice(4.00);
        p2.setImageUrl("https://images.unsplash.com/photo-1445282768818-728615cc910a?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80");
        p2.setQuantity(1);
        p2.setUser(u1);
        p2.setLocation(l1);
        p2.setCategory(c2);

        productService.save(p2);
//
        Product p3 = new Product();

        p3.setName("Beef");
        p3.setDescription("2 Kilos of premium beef cut from the not so happiest of cows!");
        p3.setPrice(14.00);
        p3.setImageUrl("https://images.unsplash.com/photo-1486172290186-a633e90efd68?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80");
        p3.setQuantity(1);
        p3.setUser(u1);
        p3.setLocation(l1);
        p3.setCategory(c1);

        productService.save(p3);

        Product p4 = new Product();

        p4.setName("Chicken");
        p4.setDescription("1 whole chicken who wasn't doing enough egg laying, take that chicken!");
        p4.setPrice(10.00);
        p4.setImageUrl("https://images.unsplash.com/photo-1553161170-0c3481941f27?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1349&q=80");
        p4.setQuantity(1);
        p4.setUser(u2);
        p4.setLocation(l2);
        p4.setCategory(c1);

        productService.save(p4);

        Product p5 = new Product();

        p5.setName("Bacon");
        p5.setDescription("2 Kilos of thick cut bacon. Babe didn't stand a chance!");
        p5.setPrice(12.00);
        p5.setImageUrl("https://images.unsplash.com/photo-1606851682837-019baf2e8da4?ixlib=rb-1.2.1&ixid=MXwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1350&q=80");
        p5.setQuantity(1);
        p5.setUser(u2);
        p5.setLocation(l2);
        p5.setCategory(c1);

        productService.save(p5);

        Product p6 = new Product();

        p6.setName("Beans");
        p6.setDescription("2 Kilos of Beans, beans, the musical fruit The more you eat, the more you toot The more you toot, the better you feel So let's have beans with every meal!");
        p6.setPrice(4.00);
        p6.setImageUrl("https://images.unsplash.com/photo-1579705745811-a32bef7856a3?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80");
        p6.setQuantity(1);
        p6.setUser(u3);
        p6.setLocation(l3);
        p6.setCategory(c2);

        productService.save(p6);

        Product p7 = new Product();

        p7.setName("Apples");
        p7.setDescription("2 Kilos of bright red apples! Sleeping Beauty doesn't stand a chance!");
        p7.setPrice(7.00);
        p7.setImageUrl("https://images.unsplash.com/photo-1506808541308-577f3be75bb7?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=748&q=80");
        p7.setQuantity(1);
        p7.setUser(u3);
        p7.setLocation(l3);
        p7.setCategory(c3);

        productService.save(p7);

        Product p8 = new Product();

        p8.setName("Avocados");
        p8.setDescription("2 Kilos of Avocados. Idk when this started going on toast but thank you");
        p8.setPrice(20.00);
        p8.setImageUrl("https://images.unsplash.com/photo-1522687297221-2d71f8c50fd5?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80");
        p8.setQuantity(1);
        p8.setUser(u4);
        p8.setLocation(l4);
        p8.setCategory(c3);

        productService.save(p8);

        Product p9 = new Product();

        p9.setName("Banana");
        p9.setDescription("2 kilos of ripe bananas, a Mario Cart weapon of doom");
        p9.setPrice(5.00);
        p9.setImageUrl("https://images.unsplash.com/photo-1580750569071-cc51212346f6?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=751&q=80");
        p9.setQuantity(1);
        p9.setUser(u4);
        p9.setLocation(l6);
        p9.setCategory(c3);

        productService.save(p9);

        Product p10 = new Product();

        p10.setName("Kale");
        p10.setDescription("2 Kilos of kale, so gross");
        p10.setPrice(10.00);
        p10.setImageUrl("https://images.unsplash.com/photo-1522193582792-c66cf1cddd16?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80");
        p10.setQuantity(1);
        p10.setUser(u5);
        p10.setLocation(l5);
        p10.setCategory(c2);

        productService.save(p10);

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
                userService.save(fakeUser);
            }
        }
    }
}