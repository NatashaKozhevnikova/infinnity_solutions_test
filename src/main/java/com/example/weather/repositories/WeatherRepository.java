package com.example.weather.repositories;

import com.example.weather.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Long> {

    List<Weather> findAllByCityAndDateAfter(String city, Date date);

    List<Weather> findAllByCityAndDateContains(String city, Date date);

    @Query(value = "SELECT w.* FROM weather w WHERE w.city = :city " +
            "AND FORMATDATETIME(w.date, 'yyyy-MM-dd') = FORMATDATETIME(:date, 'yyyy-MM-dd')", nativeQuery = true)
    List<Weather> findAllByCityAndDate(@Param("city") String city, @Param("date") Date date);
}
