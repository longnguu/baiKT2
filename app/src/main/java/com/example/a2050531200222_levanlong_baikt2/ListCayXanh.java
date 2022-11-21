package com.example.a2050531200222_levanlong_baikt2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListCayXanh extends AppCompatActivity {

    private ListView listView;
    ArrayList<CayXanh> items = new ArrayList<>();
    CayXanhAdapter adapter;
    Boolean kt=false;
    int j=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cay_xanh);
        listView = (ListView) findViewById(R.id.lvCayXanh);
        items.add(new CayXanh("Azadirachta indica","Cây sầu đông", "Sầu đâu hay còn có các tên gọi khác là sầu đông, xoan sầu đâu, xoan ăn gỏi, xoan trắng, xoan chịu hạn, xoan Ấn Độ (danh pháp hai phần: Azadirachta indica) là một cây thuộc họ Meliaceae. Loài này được A.Juss. miêu tả khoa học đầu tiên năm 1830.[3] Đây là một trong hai loài thuộc chi Azadirachta, và sống ở các quốc gia như Bangladesh, Ấn Độ, Myanma, và Pakistan, tại các khu vực nhiệt đới và bán nhiệt đới.","Xanh",R.drawable.img)) ;
        items.add(new CayXanh("Prunus arborea","Cây xoan đào", "Xoan đào[2] (danh pháp khoa học: Prunus arborea) là loài thực vật có hoa thuộc họ Hoa hồng (Rosaceae). Phân bổ nhiều nơi trên thế giới: Việt Nam, Indonesia, Malaysia, Singapore, và Thái Lan.[3][4]","Xanh",R.drawable.img_1)) ;

        adapter = new CayXanhAdapter(ListCayXanh.this,items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListCayXanh.this,DetailCayXanh.class);
                intent.putExtra("Ten",items.get(i).getTenKhoaHoc()+"\n"+items.get(i).getTenThuongGoi());
                intent.putExtra("MoTa",items.get(i).getDacTinh());
                startActivity(intent);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                kt=true;
                Xacnhanxoa(i);
                return false;
            }
        });
    }
    public void Xacnhanxoa(final int pos){
        AlertDialog.Builder alertDiaLog = new AlertDialog.Builder(ListCayXanh.this);
        alertDiaLog.setTitle("Thông báo");
        alertDiaLog.setIcon(R.mipmap.ic_launcher);
        alertDiaLog.setMessage("Bạn có muốn xóa");
        alertDiaLog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                items.remove(pos);
                adapter.notifyDataSetChanged();
            }
        });
        alertDiaLog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alertDiaLog.show();
    }
}