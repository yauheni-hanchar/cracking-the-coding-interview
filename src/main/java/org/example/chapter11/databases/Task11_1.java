package org.example.chapter11.databases;

public class Task11_1 {

  String solution =
      """
    SELECT t.*, count(a.id)
    FROM tenant t
    JOIN tenant_appartment ta
    ON t.id = ta.tenant_id
    JOIN appartment a
    ON a.id = ta.appartment_id
    GROUP BY t.id
    """;
}
