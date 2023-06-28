SELECT Dish.name, Dish.currenttype, Dish.currentsize, Dish.price, Dish.calories, Ingredient.name, Dish_Ingredient.weight  FROM Dish_Ingredient
JOIN Dish ON Dish_Ingredient.iddish = Dish.id
JOIN Ingredient ON Dish_Ingredient.idingredient = Ingredient.id
 