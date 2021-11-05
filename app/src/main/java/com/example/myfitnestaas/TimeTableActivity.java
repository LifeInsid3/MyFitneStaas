package com.example.myfitnestaas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TimeTableActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        listView = findViewById(R.id.listview);

        int [] imageId = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d,
                R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i};

        String [] name = {"Билл", "Вэн", "Рикардо", "Марк", "Брэд", "Дэнни", "Чарльз", "Томас", "Стас",};
        String [] lastMessage = {"Боксинг", "Единоборства", "Аэробика ", "Боди памп", "Стретчинг", "Пилатес", "Кроссфит", "Боди скульптура", "Сайклинг",};
        String [] lastMessageTime = {"11:00", "13:30", "14:00", "14:30", "15:00", "16:30", "17:00", "18:00", "18:30",};
        String [] phoneNo = {"7(926)067-81-22", "7(924)462-33-14", "7(924)765-82-34", "7(945)670-12-34", "7(952)123-76-89", "7(947)812-56-78", "7(923)456-01-82", "7(920)765-18-53", "7(925)613-23-75",};
        String [] country = {"Зал 1", "Зал 1", "Зал 2", "Зал 1", "Зал 3", "Зал 2", "Зал 1", "Зал 1", "Основной зал",};
        String [] info = {"Тренировка, которая выполняется в аэробном стиле с помощью специальных боксерских установок в виде груши. Основные движения – это удары руками и ногами о грушу.",
                "Различные направления в фитнес формате, в которые входят элементы тайского бокса, ку-до, каратэ, кикбоксинга, тхэквондо.",
                "Направление фитнеса, в котором простые танцевальные движения выполняются под ритмичную музыку.",
                "Силовая тренировка, направленная на укрепление всех мышцы тела с помощью штанги для фитнеса. Запатентованная методика имеет множество программ тренировок.",
                "Включает в себя упражнения на растяжку мышц, выполняемые как в статике, так и динамике. Растяжка способствует расслаблению зажатых мышц, повышает гибкость связок и волокон.",
                "Оздоровительная практика для всех возрастов, независимо от пола. Направление положительно влияет на организм в целом, способствует улучшению функций опорно-двигательного аппарата.",
                "Популярный вид спорта, который адаптирован под фитнес формат. Для кроссфита существуют специализированные залы и нестандартное для других направлений фитнеса оборудование.",
                "Комплекс направлений, в который входят силовые тренировки, развивающие разные части тела. Например, Upper body направлено на развитие плечевого пояса, Butt+fleks – ягодичные мышцы и бедра.",
                "Групповая тренировка, которая проходит на сайклах и имитирует велоезду по пересеченной местности и в гору. Основная часть занятия – изменение нагрузки и скорости езды, завершающая часть – силовые упражнения на все группы мышц.",};

        ArrayList<User> userArrayList = new ArrayList();

        for (int i = 0; i<imageId.length; i++)
        {
            User user = new User(name[i], lastMessage[i], lastMessageTime[i],
                    phoneNo[i], country[i], info[i], imageId[i]);
            userArrayList.add(user);
        }


        ListAdapter listAdapter = new ListAdapter(TimeTableActivity.this, userArrayList);

        listView.setAdapter(listAdapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent = new Intent(TimeTableActivity.this, UserActivity.class);
                intent.putExtra("name", name[i]);
                intent.putExtra("phoneNo", phoneNo[i]);
                intent.putExtra("country", country[i]);
                intent.putExtra("imageid", imageId[i]);
                intent.putExtra("info", info[i]);
                startActivity(intent);
            }
        });
    }


}