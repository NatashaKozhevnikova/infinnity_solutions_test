insert into provider (name, url, type)
values ('OpenWeather', 'https://api.openweathermap.org/data/2.5/weather?q=%city%&appid=f63245171f3ebf5f0137c7eb28cdd6da&units=metric', 0),
       ('SoapHeroku', 'https://soapproduce.herokuapp.com/ws', 1);


insert into weather (city, date, temperature, provider_id)
values ('Moscow', '2020-10-05 12:15:00', -5, 1),
       ('Moscow', '2020-10-05 13:15:00', -4, 1),
       ('Moscow', '2020-10-05 14:15:00', -4, 1),
       ('Moscow', '2020-10-05 15:15:00', -3, 1),
       ('Moscow', '2020-10-05 16:15:00', -4, 1),
       ('Moscow', '2020-10-05 17:15:00', -6, 1),
       ('Moscow', '2020-10-06 13:15:00', 0, 1),
       ('Moscow', '2020-10-06 14:15:00', 1, 1),
       ('Moscow', '2020-10-06 15:15:00', 2, 1),
       ('Moscow', '2020-10-06 16:15:00', 3, 1),
       ('Moscow', '2020-10-06 17:15:00', -1, 1),
       ('Moscow', '2020-10-06 18:15:00', -1, 1),
       ('Moscow', '2020-11-05 13:15:00', 1, 1),
       ('Moscow', '2020-11-05 13:15:00', 1, 1),
       ('Moscow', '2020-11-05 13:15:00', 1, 1),
       ('Moscow', '2020-11-05 13:15:00', 1, 1),
       ('Moscow', '2020-11-05 13:15:00', 2, 1),
       ('Moscow', '2020-12-05 13:15:00', -10, 1),
       ('Moscow', '2020-12-05 14:15:00', -12, 1)
