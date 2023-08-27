


INSERT INTO users (email, password, name, role) VALUES ('deluca@bokafood.com', '$2a$12$XsDaXFVF3frK/uHfnnRjp.mvKvd/ynPF6furYtpZQRCw03ZZy6YYu', 'Luigi', 'ADMIN');
INSERT INTO users (email, password, name, role) VALUES ('yaya@mail.com', '$2a$12$mOYffKTc2oUgV4vNTcRdEOuGrFshHaze.g74w08ZSwrHaWTu0VWFS', 'Yaya', 'ADMIN');
INSERT INTO users (email, password, name, role) VALUES ('leogobelus@mail.com', '$2a$12$.l2KuerB/ES8LO/mNiCjE.JC4cjGg/.6DpJnp.KOxyn.H395Js36m', 'Leo', 'EMPLOYEE');
INSERT INTO users (email, password, name, role) VALUES ('jean@mail.com', '$2a$12$.l2KuerB/ES8LO/mNiCjE.JC4cjGg/.6DpJnp.KOxyn.H395Js36m', 'Jean-Charles Roger Henry-Louis', 'ADMIN');

INSERT INTO CLIENT (name, addressname, addressnumber, zipcode, city) VALUES ('Boka Fitness', 'Avenue de Flon', 11, 1012, 'Lausannne');
INSERT INTO CLIENT (name, addressname, addressnumber, zipcode, city) VALUES ('Planet Fitness', 'Avenue de Wallstreet', 12, 1013, 'Lausannne');
INSERT INTO CLIENT (name, addressname, addressnumber, zipcode, city) VALUES ('Pompiers de Morges', 'Avenue de la Gare', 13, 1014, 'Morges');
INSERT INTO CLIENT (name, addressname, addressnumber, zipcode, city) VALUES ('Fit Corporation', 'Avenu de la Riponne', 22, 1015, 'Lausanne');
INSERT INTO CLIENT (name, addressname, addressnumber, zipcode, city) VALUES ('Police de Genève', 'Avenue du Cervin', 7, 1016, 'Geneva');
INSERT INTO CLIENT (name, addressname, addressnumber, zipcode, city) VALUES ('High Tech SA', 'Rue de la place', 5, 1017, 'Zurich');
INSERT INTO CLIENT (name, addressname, addressnumber, zipcode, city) VALUES ('Architects and Co', 'Grande place', 15, 1018, 'Bern');
INSERT INTO CLIENT (name, addressname, addressnumber, zipcode, city) VALUES ('Hardware réparation', 'Rue du poisson', 11, 1031, 'Lausanne');
INSERT INTO CLIENT (name, addressname, addressnumber, zipcode, city) VALUES ('Gilbert Immobilier et fils', 'Avenue des Idées', 8, 1032, 'Geneva');
INSERT INTO CLIENT (name, addressname, addressnumber, zipcode, city) VALUES ('GameXMatch Studio', 'Rue du Bourg', 11, 1012, 'Lausanne');
INSERT INTO CLIENT (name, addressname, addressnumber, zipcode, city) VALUES ('Marketing et Innovation SA', 'Avenue des Idées', 9, 1032, 'Geneva');


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
INSERT INTO Ingredient (name, currentType, description, supplier) VALUES ('Tofu', 'VEGETABLE', 'Soybean-based protein source', 'Local Tofu Farm');
INSERT INTO Ingredient (name, currentType, description, supplier) VALUES ('Rice Noodles', 'GRAIN', 'Thin and translucent noodles made from rice flour', 'Asian Food Distributors');
INSERT INTO Ingredient (name, currentType, description, supplier) VALUES ('Basil', 'VEGETABLE', 'Aromatic herb with a sweet and peppery flavor', 'Fresh Herb Farms');
INSERT INTO Ingredient (name, currentType, description, supplier) VALUES ('Lime', 'FRUIT', 'Citrus fruit with a tangy and refreshing flavor', 'Citrus Grove');
INSERT INTO Ingredient (name, currentType, description, supplier) VALUES ('Mozzarella Cheese', 'OTHER', 'Soft and mild cheese made from buffalo or cows milk', 'Artisan Cheese Company');
INSERT INTO Ingredient (name, currentType, description, supplier) VALUES ('Mixed Vegetables', 'VEGETABLE', 'Assorted fresh vegetables', 'Local Farmers Market');
INSERT INTO Ingredient (name, currentType, description, supplier) VALUES ('Tomatoes', 'FRUIT', 'Ripe and juicy tomatoes', 'Local Tomato Farm');

INSERT INTO DISH (name, description, currenttype, currentsize, price, isavailable, calories, fats, saturatedfats, fibers, sugars, proteins) VALUES ('Chicken Piri Piri', 'Chicken piri piri Portuguese style', 'MEAT', 'FIT', 10.50, true, 650, 10.2, 8.7, 3.5, 8.6, 30);
INSERT INTO DISH (name, description, currenttype, currentsize, price, isavailable, calories) VALUES ('Beef Stir-Fry', 'Tender beef slices with mixed vegetables, stir-fried in a savory sauce', 'MEAT', 'GAIN', 14.99, true, 720);
INSERT INTO DISH (name, description, currenttype, currentsize, price, isavailable, calories) VALUES ('Pork Tenderloin with Apple Compote', 'Juicy pork tenderloin served with a sweet and tangy apple compote', 'MEAT', 'GAIN', 16.50, false, 620);
INSERT INTO DISH (name, description, currenttype, currentsize, price, isavailable, calories) VALUES ('Grilled Salmon with Lemon Butter Sauce', 'Fresh grilled salmon fillet topped with a zesty lemon butter sauce', 'MEAT', 'GAIN', 18.99, true, 560);
INSERT INTO DISH (name, description, currenttype, currentsize, price, isavailable, calories) VALUES ('Tuna Poke Bowl', 'Marinated tuna cubes served over a bed of rice with fresh vegetables and a soy-based sauce', 'MEAT', 'FIT', 15.75, true, 480);
INSERT INTO DISH (name, description, currenttype, currentsize, price, isavailable, calories) VALUES ('Basmati Rice Pilaf with Vegetables', 'Fragrant basmati rice cooked with assorted vegetables and aromatic spices and honey', 'VEGETARIAN', 'GAIN', 9.99, true, 380);
INSERT INTO DISH (name, description, currenttype, currentsize, price, isavailable, calories) VALUES ('Creamy Pesto Pasta', 'Penne pasta tossed in a creamy pesto sauce, topped with vegan Parmesan cheese', 'VEGAN', 'GAIN', 13.50, true, 620);
INSERT INTO Dish (name, description, currenttype, currentsize, price, isavailable, calories, fats, saturatedfats, fibers, sugars, proteins) VALUES ('Vegan Pad Thai', 'Classic Thai stir-fried rice noodles with tofu, vegetables, and a tangy sauce', 'VEGAN', 'FIT', 12.99, true, 520, 9.4, 1.8, 7.6, 6.3, 15.2);
INSERT INTO Dish (name, description, currenttype, currentsize, price, isavailable, calories, fats, saturatedfats, fibers, sugars, proteins) VALUES ('Caprese Salad', 'Classic Italian salad with ripe tomatoes, fresh mozzarella cheese, basil, and balsamic glaze', 'VEGETARIAN', 'FIT', 8.50, true, 320, 23.8, 10.7, 3.4, 4.7, 17.3);
INSERT INTO Dish (name, description, currenttype, currentsize, price, isavailable, calories, fats, saturatedfats, fibers, sugars, proteins) VALUES ('Grilled Chicken Breast', 'Lean and juicy grilled chicken breast served with steamed vegetables', 'MEAT', 'FIT', 9.99, true, 280, 4.6, 1.2, 1.5, 0.5, 53.2);
INSERT INTO Dish (name, description, currenttype, currentsize, price, isavailable, calories, fats, saturatedfats, fibers, sugars, proteins) VALUES ('Spaghetti Bolognese', 'Classic Italian dish with spaghetti pasta and a rich meat sauce', 'MEAT', 'GAIN', 11.50, true, 820, 15.2, 7.5, 7.3, 10.1, 38.9);




-- Chicken Piri Piri (Chicken, Lemons, Garlic)
INSERT INTO dish_ingredient (idDish, idIngredient, weight)
VALUES (1, 1, 500), -- Chicken (250g)
       (1, 14, 2),  -- Lemons (2 units)
       (1, 12, 10); -- Garlic (10 cloves)

-- Beef Stir-Fry (Beef, Bell Peppers, Carrots, Jasmine Rice)
INSERT INTO dish_ingredient (idDish, idIngredient, weight)
VALUES (2, 2, 400),  -- Beef (400g)
       (2, 16, 2),   -- Bell Peppers (2 units)
       (2, 10, 150),  -- Carrots (150g)
       (2, 7, 200);  -- Jasmine Rice (200g)

-- Grilled Salmon with Lemon Butter Sauce (Salmon, Lemons, Garlic)
INSERT INTO dish_ingredient (idDish, idIngredient, weight)
VALUES (5, 4, 300),  -- Salmon (300g)
       (5, 14, 5),   -- Lemons (5 g)
       (5, 12, 10);   -- Garlic (10 g)
	   
-- Vegan Dish Ingredients: Vegan Pad Thai (Tofu, Rice Noodles, Bell Peppers, Carrots)
INSERT INTO Dish_Ingredient (idDish, idIngredient, weight)
VALUES (7, 18, 200),   -- Tofu (200g)
       (7, 19, 150),   -- Rice Noodles (150g)
       (7, 16, 2),     -- Bell Peppers (2 units)
       (7, 10, 100);   -- Carrots (100g)

-- Vegetarian Dish Ingredients: Caprese Salad (Tomatoes, Mozzarella Cheese, Basil)
INSERT INTO Dish_Ingredient (idDish, idIngredient, weight)
VALUES (8, 20, 200),   -- Tomatoes (200g)
       (8, 21, 150),   -- Mozzarella Cheese (150g)
       (8, 22, 20);    -- Basil (20g)
	   
-- Fit Dish Ingredients: Grilled Chicken Breast (Chicken, Mixed Vegetables)
INSERT INTO Dish_Ingredient (idDish, idIngredient, weight)
VALUES (9, 1, 200),   -- Chicken (200g)
       (9, 11, 200);  -- Mixed Vegetables (200g)
	   
-- Gain Dish Ingredients: Spaghetti Bolognese (Beef, Spaghetti, Garlic, Tomatoes)
INSERT INTO Dish_Ingredient (idDish, idIngredient, weight)
VALUES (10, 2, 300),   -- Beef (300g)
       (10, 8, 200),   -- Spaghetti (200g)
       (10, 12, 5),    -- Garlic (5 cloves)
       (10, 20, 300);  -- Tomatoes (300g)
	  
INSERT INTO Delivery (idClient, idUser, deliveryDate, details) VALUES (1, 1, '2023-06-30', 'late delivery');
INSERT INTO Delivery (idClient, idUser, deliveryDate, details) VALUES (1, 2, '2023-07-01', 'missed some plates');
INSERT INTO Delivery (idClient, idUser, deliveryDate) VALUES (2, 1, '2023-07-02');
INSERT INTO Delivery (idClient, idUser, deliveryDate, details) VALUES (2, 2, '2023-07-03', 'took too much plates');
INSERT INTO Delivery (idClient, idUser, deliveryDate, details) VALUES (1, 1, '2023-07-05', 'On-time delivery');
INSERT INTO Delivery (idClient, idUser, deliveryDate) VALUES (2, 2, '2023-07-06');
INSERT INTO Delivery (idClient, idUser, deliveryDate, details) VALUES (3, 1, '2023-07-07', 'Missing side dish');



INSERT INTO delivery_dish (iddelivery, iddish, quantityremained, quantitydelivered) VALUES (1, 1, 3, 7);
INSERT INTO delivery_dish (iddelivery, iddish, quantityremained, quantitydelivered) VALUES (1, 2, 0, 10);
INSERT INTO delivery_dish (iddelivery, iddish, quantityremained, quantitydelivered) VALUES (2, 3, 5, 5);
INSERT INTO delivery_dish (iddelivery, iddish, quantityremained, quantitydelivered) VALUES (2, 4, 2, 8);
INSERT INTO delivery_dish (iddelivery, iddish, quantityremained, quantitydelivered) VALUES (3, 1, 10, 0);
INSERT INTO delivery_dish (iddelivery, iddish, quantityremained, quantitydelivered) VALUES (3, 3, 4, 6);
INSERT INTO delivery_dish (iddelivery, iddish, quantityremained, quantitydelivered) VALUES (4, 2, 0, 12);
INSERT INTO delivery_dish (iddelivery, iddish, quantityremained, quantitydelivered) VALUES (4, 4, 6, 4);
INSERT INTO Delivery_Dish (idDelivery, idDish, quantityRemained, quantityDelivered) VALUES (5, 7, 5, 5);  -- Vegan Pad Thai (FIT)
INSERT INTO Delivery_Dish (idDelivery, idDish, quantityRemained, quantityDelivered) VALUES (5, 8, 7, 3);  -- Caprese Salad (FIT)
INSERT INTO Delivery_Dish (idDelivery, idDish, quantityRemained, quantityDelivered) VALUES (6, 7, 8, 2);  -- Vegan Pad Thai (GAIN)
INSERT INTO Delivery_Dish (idDelivery, idDish, quantityRemained, quantityDelivered) VALUES (6, 9, 10, 0); -- Grilled Chicken Breast (GAIN)
INSERT INTO Delivery_Dish (idDelivery, idDish, quantityRemained, quantityDelivered) VALUES (7, 8, 5, 5);  -- Caprese Salad (FIT)
INSERT INTO Delivery_Dish (idDelivery, idDish, quantityRemained, quantityDelivered) VALUES (7, 9, 12, 0); -- Grilled Chicken Breast (FIT)
