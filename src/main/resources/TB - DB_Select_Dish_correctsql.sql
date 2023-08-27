SELECT Dish.name, Dish.currenttype, Dish.currentsize, Dish.price, Dish.calories, Ingredient.name, Dish_Ingredient.weight FROM Dish
LEFT JOIN Dish_Ingredient ON Dish.id = Dish_Ingredient.idDish
LEFT JOIN Ingredient ON Dish_Ingredient.idIngredient = Ingredient.id