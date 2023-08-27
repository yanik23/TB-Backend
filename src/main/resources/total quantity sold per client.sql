SELECT c.id AS clientId, c."name" AS clientName, 
       SUM(dd.quantityRemained - COALESCE(prev_delivery.quantityDelivered, 0)) AS totalQuantitySold
FROM Client c
JOIN Delivery d ON c.id = d.idClient
JOIN Delivery_Dish dd ON d.id = dd.idDelivery
LEFT JOIN LATERAL (
    SELECT quantityDelivered
    FROM Delivery_Dish
    WHERE idDelivery = (
        SELECT MAX(id)
        FROM Delivery
        WHERE id < d.id AND idClient = c.id
    )
    ORDER BY idDelivery DESC
    LIMIT 1
) AS prev_delivery ON true
GROUP BY c.id, c."name";