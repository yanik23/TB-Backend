SELECT d.currentType AS dishType, SUM(dd.quantityDelivered) AS totalQuantityDelivered
FROM Dish d
JOIN Delivery_Dish dd ON d.id = dd.idDish
GROUP BY d.currentType;