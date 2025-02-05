/*1.Crea la base de datos*/
use pokemonDB;

/*2.Muestra las colecciones (no debe tener ninguna)*/
show collections;


/*3.Crea las colecciones. Plantea colecciones que tengan arrays y
documentos. Haz uso de los patrones (embeber y/o relacionar)*/
db.createCollection("Pokemon");
db.createCollection("Player");

/*4.Inserta documentos (uno a uno) en una de las colecciones.*/
db.Pokemon.insertOne({
  "_id": ObjectId("60c72b2f9f1b2c6a8f3c3a53"),
  "nombre": "Charizard",
  "tipo": ["Fuego", "Volador"],
  "nivel": 50,
  "estadisticas": {
    "hp": 78,
    "ataque": 84,
    "defensa": 78,
    "velocidad": 100
  },
  "ataques": [
    { "nombre": "Lanzallamas", "daño": 90 },
    { "nombre": "Garra Dragón", "daño": 80 }
  ]
});

db.Pokemon.insertOne({
  "_id": ObjectId("60c72b2f9f1b2c6a8f3c3a54"),
  "nombre": "Pikachu",
  "tipo": ["Eléctrico"],
  "nivel": 25,
  "estadisticas": {
    "hp": 35,
    "ataque": 55,
    "defensa": 40,
    "velocidad": 90
  },
  "ataques": [
    { "nombre": "Impactrueno", "daño": 40 },
    { "nombre": "Rayo", "daño": 90 }
  ]
});

db.Pokemon.insertOne({
  "_id": ObjectId("60c72b2f9f1b2c6a8f3c3a55"),
  "nombre": "Bulbasaur",
  "tipo": ["Planta", "Veneno"],
  "nivel": 16,
  "estadisticas": {
    "hp": 45,
    "ataque": 49,
    "defensa": 49,
    "velocidad": 45
  },
  "ataques": [
    { "nombre": "Latigazo", "daño": 45 },
    { "nombre": "Rayo Solar", "daño": 120 }
  ]
});

db.Pokemon.insertOne({
  "_id": ObjectId("60c72b2f9f1b2c6a8f3c3a56"),
  "nombre": "Squirtle",
  "tipo": ["Agua"],
  "nivel": 18,
  "estadisticas": {
    "hp": 44,
    "ataque": 48,
    "defensa": 65,
    "velocidad": 43
  },
  "ataques": [
    { "nombre": "Pistola Agua", "daño": 40 },
    { "nombre": "Hidrobomba", "daño": 110 }
  ]
});

db.Player.insertOne({
  "nombre": "Ash Lin",
  "nivel": 24,
  "equipo": [
    { "pokemon_id": ObjectId("60c72b2f9f1b2c6a8f3c3a53"), "apodo": "Char" },
    { "pokemon_id": ObjectId("60c72b2f9f1b2c6a8f3c3a54"), "apodo": "Pika" }
  ],
  "logros": [
    { "nombre": "Campeón de Kanto", "fecha": "2019-12-10" },
    { "nombre": "Medalla Roca", "fecha": "2010-11-15" }
  ]
});

db.Player.insertOne({
  "nombre": "Jazael",
  "nivel": 21,
  "equipo": [
    { "pokemon_id": ObjectId("60c72b2f9f1b2c6a8f3c3a56"), "apodo": "Squir" },
    { "pokemon_id": ObjectId("60c72b2f9f1b2c6a8f3c3a55"), "apodo": "Bulba" }
  ],
  "logros": [
    { "nombre": "Campeón de Kanto", "fecha": "2024-12-10" },
    { "nombre": "Medalla Roca", "fecha": "2023-11-15" }
  ]
});



/*5.Inserta 10 documentos a la vez en la otra colección.*/

db.Pokemon.insertMany([
  {
    "nombre": "Pikachu",
    "tipo": ["Eléctrico"],
    "nivel": 25,
    "estadisticas": { "hp": 35, "ataque": 55, "defensa": 40, "velocidad": 90 },
    "ataques": [{ "nombre": "Impactrueno", "daño": 40 }, { "nombre": "Rayo", "daño": 90 }]
  },
  {
    "nombre": "Charizard",
    "tipo": ["Fuego", "Volador"],
    "nivel": 50,
    "estadisticas": { "hp": 78, "ataque": 84, "defensa": 78, "velocidad": 100 },
    "ataques": [{ "nombre": "Lanzallamas", "daño": 90 }, { "nombre": "Garra Dragón", "daño": 80 }]
  },
  {
    "nombre": "Bulbasaur",
    "tipo": ["Planta", "Veneno"],
    "nivel": 16,
    "estadisticas": { "hp": 45, "ataque": 49, "defensa": 49, "velocidad": 45 },
    "ataques": [{ "nombre": "Latigazo", "daño": 45 }, { "nombre": "Rayo Solar", "daño": 120 }]
  },
  {
    "nombre": "Squirtle",
    "tipo": ["Agua"],
    "nivel": 18,
    "estadisticas": { "hp": 44, "ataque": 48, "defensa": 65, "velocidad": 43 },
    "ataques": [{ "nombre": "Pistola Agua", "daño": 40 }, { "nombre": "Hidrobomba", "daño": 110 }]
  },
  {
    "nombre": "Jigglypuff",
    "tipo": ["Normal", "Hada"],
    "nivel": 20,
    "estadisticas": { "hp": 115, "ataque": 45, "defensa": 20, "velocidad": 20 },
    "ataques": [{ "nombre": "Canto", "daño": 0 }, { "nombre": "Doble Bofetón", "daño": 30 }]
  },
  {
    "nombre": "Gengar",
    "tipo": ["Fantasma", "Veneno"],
    "nivel": 45,
    "estadisticas": { "hp": 60, "ataque": 65, "defensa": 60, "velocidad": 110 },
    "ataques": [{ "nombre": "Bola Sombra", "daño": 80 }, { "nombre": "Lengüetazo", "daño": 30 }]
  },
  {
    "nombre": "Eevee",
    "tipo": ["Normal"],
    "nivel": 10,
    "estadisticas": { "hp": 55, "ataque": 55, "defensa": 50, "velocidad": 55 },
    "ataques": [{ "nombre": "Ataque Rápido", "daño": 40 }, { "nombre": "Mordisco", "daño": 60 }]
  },
  {
    "nombre": "Snorlax",
    "tipo": ["Normal"],
    "nivel": 35,
    "estadisticas": { "hp": 160, "ataque": 110, "defensa": 65, "velocidad": 30 },
    "ataques": [{ "nombre": "Placaje", "daño": 50 }, { "nombre": "Descanso", "daño": 0 }]
  },
  {
    "nombre": "Dragonite",
    "tipo": ["Dragón", "Volador"],
    "nivel": 55,
    "estadisticas": { "hp": 91, "ataque": 134, "defensa": 95, "velocidad": 80 },
    "ataques": [{ "nombre": "Puño Trueno", "daño": 75 }, { "nombre": "Cola Dragón", "daño": 60 }]
  },
  {
    "nombre": "Lucario",
    "tipo": ["Lucha", "Acero"],
    "nivel": 40,
    "estadisticas": { "hp": 70, "ataque": 110, "defensa": 70, "velocidad": 90 },
    "ataques": [{ "nombre": "Esfera Aural", "daño": 80 }, { "nombre": "Golpe Roca", "daño": 50 }]
  }
])



/*6.Plantea cinco consultas (enunciado y sentencia)*/

    /*6.1 Mostrar todos los Pokémon*/
    db.Pokemon.find({})
    
    /*6.2 Buscar Pokémon por tipo Fuego*/
    db.Pokemon.find({"tipo":"Fuego"})
    /*6.3 Buscar nombre de pokémon con ataque superior a 100*/
    db.Pokemon.find({"estadisticas.ataque":{$gt:100}},{"_id":0,"nombre":1})
    /*6.4 Mostrar todos los players*/
    db.Player.find({})
    /*6.5 Mostrar jugador que tenga un pokemon especifico dado por id*/
    db.Player.find({ "equipo.pokemon_id": ObjectId("67a38eb6d41661b5ce072f8c")})
    

/*7.Plantea dos agregaciones (enunciado y sentencia)*/
    /*7.1 Contar el total de pokemon*/
    db.Pokemon.aggregate([{$count:"totalPokemons"}]);
    /*7.2 Ordenar el nivel de pokemon de mayor a menor*/
    db.Pokemon.aggregate([{$sort:{"nivel":-1}}])

/*8.Realiza cuatro actualizaciones. Deben realizarse sobre un campo
específico de un documento concreto y sobre un campo específico
de todos los documentos que coincidan con un filtro (lo planteas tú)*/
    /*8.1 Actualizar el nivel del Pokémon "Pikachu" a 30.*/
    db.Pokemon.updateOne({"nombre":"Pikachu"},{$set:{"nivel":30}})
    /*8.2 Actualizar el ataque de "Charizard" a 95.*/
    db.Pokemon.updateOne({"nombre":"Charizard"},{$set:{"estadisticas.ataque":95}})
    /*8.3 Aumentar en 5 el nivel de todos los Pokémon de tipo "Agua".*/
    db.Pokemon.updateMany({"tipo":"Agua"},{$inc:{"nivel":5}})
    /*8.4 Agregar un nuevo ataque a todos los pokemon.*/
    db.Pokemon.updateMany({},{$push:{ "ataques": { "nombre": "Hacerse adorable", "daño": 9999 }}})

/*9.Realiza borrado de documentos que cumplan con diferentes filtros
(al menos 3)*/
    /*9.1 Eliminar Pokémon de tipo Lucha*/
    db.Pokemon.deleteMany({"tipo":"Lucha"})
    /*9.2 Eliminar pokemon con nivel bajo 5*/
    db.Pokemon.deleteMany({"nivel":{$lt:20}})
    /*9.3 Eliminar pokemon con ataque Rayo*/
    db.Pokemon.deleteMany({"ataques.nombre":"Rayo"})
    /*9.4 Eliminar pokemon con daño menor de 100*/
    db.Pokemon.deleteMany({"ataques.daño":{$lt:100}})


