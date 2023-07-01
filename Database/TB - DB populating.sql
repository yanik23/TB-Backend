


INSERT INTO "user" (email, password, name, currentrole) VALUES ('deluca@bokafood.com', 'admin', 'Luigi', 'ADMIN');
INSERT INTO "user" (email, password, name, currentrole) VALUES ('yaya@mail.com', '1234', 'Yaya', 'EMPLOYEE');
INSERT INTO "user" (email, password, name, currentrole) VALUES ('leogobelus@mail.com', 'ilovebannerlord', 'Leonardo', 'EMPLOYEE');

INSERT INTO CLIENT (name, addressname, addressnumber, zipcode, city) VALUES ('Boka Fitness', 'Avenue de Flon', 11, 1012, 'Lausannne');
INSERT INTO CLIENT (name, addressname, addressnumber, zipcode, city) VALUES ('Planet Fitness', 'Avenue de Wallstreet', 12, 1013, 'Lausannne');
INSERT INTO CLIENT (name, addressname, addressnumber, zipcode, city) VALUES ('Pompiers de Morges', 'Avenue de la Gare', 13, 1014, 'Morges');

INSERT INTO INGREDIENT (name, currenttype, description, supplier) VALUES ('Chicken', 'MEAT', 'Farming chicken', 'La ferme des 4 lacs');
INSERT INTO INGREDIENT (name, currenttype, description, supplier) VALUES ('Beef', 'MEAT', 'Grass-fed beef', 'Local Butcher Shop');
INSERT INTO INGREDIENT (name, currenttype, description, supplier) VALUES ('Pork', 'MEAT', 'Heritage breed pork', 'Smith Family Farms');
INSERT INTO INGREDIENT (name, currenttype, description, supplier) VALUES ('Salmon', 'FISH', 'Wild-caught salmon', 'Ocean Seafood Company');
INSERT INTO INGREDIENT (name, currenttype, description, supplier) VALUES ('Tuna', 'FISH', 'Yellowfin tuna', 'Fresh Fish Market');
INSERT INTO INGREDIENT (name, currenttype, description, supplier) VALUES ('Basmati Rice', 'GRAIN', 'Long-grain aromatic rice', 'Global Rice Traders');
INSERT INTO INGREDIENT (name, currenttype, description, supplier) VALUES ('Jasmine Rice', 'GRAIN', 'Fragrant Thai rice', 'Asian Food Distributors');
INSERT INTO INGREDIENT (name, currenttype, description, supplier) VALUES ('Spaghetti', 'STARCH', 'Long, thin cylindrical pasta', 'Italian Pasta Company');
INSERT INTO INGREDIENT (name, currenttype, description, supplier) VALUES ('Penne', 'STARCH', 'Short, tube-shaped pasta', 'Pasta Delights Corporation');
INSERT INTO INGREDIENT (name, currenttype, description, supplier) VALUES ('Carrots', 'VEGETABLE', 'Orange root vegetable that is sweet and crunchy.', 'Local farmers'' market');
INSERT INTO INGREDIENT (name, currenttype, description, supplier) VALUES ('Apples', 'FRUIT', 'Round fruit with a crisp and juicy texture, available in various colors and flavors.', 'Orchard Farms');
INSERT INTO INGREDIENT (name, currenttype, description, supplier) VALUES ('Garlic', 'SPICE', 'Bulbous plant with a pungent flavor, commonly used as a seasoning in various cuisines.', 'Spices R Us');
INSERT INTO INGREDIENT (name, currenttype, description, supplier) VALUES ('Spinach', 'VEGETABLE', 'Leafy green vegetable known for its high nutritional value and versatility in cooking.', 'Organic Greens Farm');
INSERT INTO INGREDIENT (name, currenttype, description, supplier) VALUES ('Lemons', 'FRUIT', 'Citrus fruit with a sour taste and refreshing aroma, commonly used for its juice and zest.', 'Orchard Farms');
INSERT INTO INGREDIENT (name, currenttype, description, supplier) VALUES ('Cumin', 'SPICE', 'Aromatic spice with a warm, earthy flavor, widely used in Middle Eastern and Indian cuisine.', 'Global Spice Traders');
INSERT INTO INGREDIENT (name, currenttype, description, supplier) VALUES ('Bell Peppers', 'VEGETABLE', 'Sweet and colorful peppers available in various hues, such as red, yellow, and green.', 'Fresh Harvest Farms');
INSERT INTO INGREDIENT (name, currenttype, description, supplier) VALUES ('Blueberries', 'FRUIT', 'Small, sweet berries known for their deep blue color and high antioxidant content.', 'Berry Delights Co-op');
INSERT INTO INGREDIENT (name, currenttype, description, supplier) VALUES ('Turmeric', 'SPICE', 'Bright yellow spice with a warm, peppery flavor, often used in curries and other dishes.', 'Exotic Spices Emporium');
INSERT INTO INGREDIENT (name, currenttype, description, supplier) VALUES ('Zucchini', 'VEGETABLE', 'Summer squash with a mild flavor and tender texture, commonly used in salads, stir-fries, or as a vegetable substitute.', 'Local Organic Farms');


INSERT INTO DISH (name, description, currenttype, currentsize, price, isavailable, calories) VALUES ('Chicken Piri Piri', 'Chicken piri piri portugese style', 'MEAT', 'GAIN', 12.50, true, 850);
INSERT INTO DISH (name, description, currenttype, currentsize, price, isavailable, calories) VALUES ('Chicken Piri Piri', 'Chicken piri piri Portuguese style', 'MEAT', 'FIT', 10.50, true, 650);
INSERT INTO DISH (name, description, currenttype, currentsize, price, isavailable, calories) VALUES ('Beef Stir-Fry', 'Tender beef slices with mixed vegetables, stir-fried in a savory sauce', 'MEAT', 'GAIN', 14.99, true, 720);
INSERT INTO DISH (name, description, currenttype, currentsize, price, isavailable, calories) VALUES ('Pork Tenderloin with Apple Compote', 'Juicy pork tenderloin served with a sweet and tangy apple compote', 'MEAT', 'GAIN', 16.50, false, 620);
INSERT INTO DISH (name, description, currenttype, currentsize, price, isavailable, calories) VALUES ('Grilled Salmon with Lemon Butter Sauce', 'Fresh grilled salmon fillet topped with a zesty lemon butter sauce', 'MEAT', 'GAIN', 18.99, true, 560);
INSERT INTO DISH (name, description, currenttype, currentsize, price, isavailable, calories) VALUES ('Tuna Poke Bowl', 'Marinated tuna cubes served over a bed of rice with fresh vegetables and a soy-based sauce', 'MEAT', 'FIT', 15.75, true, 480);
INSERT INTO DISH (name, description, currenttype, currentsize, price, isavailable, calories) VALUES ('Basmati Rice Pilaf with Vegetables', 'Fragrant basmati rice cooked with assorted vegetables and aromatic spices and honey', 'VEGETARIAN', 'GAIN', 9.99, true, 380);
INSERT INTO DISH (name, description, currenttype, currentsize, price, isavailable, calories) VALUES ('Creamy Pesto Pasta', 'Penne pasta tossed in a creamy pesto sauce, topped with vegan Parmesan cheese', 'VEGAN', 'GAIN', 13.50, true, 620);


-- Chicken Piri Piri (Chicken, Lemons, Garlic)
INSERT INTO dish_ingredient (idDish, idIngredient, weight)
VALUES (1, 1, 500), -- Chicken (250g)
       (1, 12, 2),  -- Lemons (2 units)
       (1, 11, 10); -- Garlic (10 cloves)

-- Beef Stir-Fry (Beef, Bell Peppers, Carrots, Jasmine Rice)
INSERT INTO dish_ingredient (idDish, idIngredient, weight)
VALUES (2, 2, 400),  -- Beef (400g)
       (2, 14, 2),   -- Bell Peppers (2 units)
       (2, 8, 150),  -- Carrots (150g)
       (2, 5, 200);  -- Jasmine Rice (200g)

-- Grilled Salmon with Lemon Butter Sauce (Salmon, Lemons, Garlic)
INSERT INTO dish_ingredient (idDish, idIngredient, weight)
VALUES (5, 3, 300),  -- Salmon (300g)
       (5, 12, 5),   -- Lemons (5 g)
       (5, 11, 10);   -- Garlic (10 g)
	   
	  
INSERT INTO Delivery (idClient, idUser, deliveryDate, details) VALUES (1, 1, '2023-06-30', 'late delivery');
INSERT INTO Delivery (idClient, idUser, deliveryDate, details) VALUES (1, 2, '2023-07-01', 'missed some plates');
INSERT INTO Delivery (idClient, idUser, deliveryDate) VALUES (2, 1, '2023-07-02');
INSERT INTO Delivery (idClient, idUser, deliveryDate, details) VALUES (2, 2, '2023-07-03', 'took too much plates');



INSERT INTO delivery_dish (iddelivery, iddish, quantityremained, quantitydelivered) VALUES (1, 1, 3, 7);
INSERT INTO delivery_dish (iddelivery, iddish, quantityremained, quantitydelivered) VALUES (1, 2, 0, 10);
INSERT INTO delivery_dish (iddelivery, iddish, quantityremained, quantitydelivered) VALUES (2, 3, 5, 5);
INSERT INTO delivery_dish (iddelivery, iddish, quantityremained, quantitydelivered) VALUES (2, 4, 2, 8);
INSERT INTO delivery_dish (iddelivery, iddish, quantityremained, quantitydelivered) VALUES (3, 1, 10, 0);
INSERT INTO delivery_dish (iddelivery, iddish, quantityremained, quantitydelivered) VALUES (3, 3, 4, 6);
INSERT INTO delivery_dish (iddelivery, iddish, quantityremained, quantitydelivered) VALUES (4, 2, 0, 12);
INSERT INTO delivery_dish (iddelivery, iddish, quantityremained, quantitydelivered) VALUES (4, 4, 6, 4);
