package com.example.webservice;

import androidx.fragment.app.DialogFragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.app.AlertDialog;

public class DialogResp //extends DialogFragment
    {

        public DialogResp()
            {

            }

        public void YNAlterData(String add, Activity act, DBCep cpp, int caso)
            {
            String title    = "";
            String msg      = "";

            CEPDAO cepdao = new CEPDAO(act.getBaseContext() );

            switch (caso)
                {
                case 0: //Salvar
                    {
                    cepdao.salvar(cpp);
                    title    = "CEP RETORNADO!";
                    msg      = "Deseja adicionar o CEP abaixo na sua lista \\n \\n "+add;
                    }break;

                case 1: //Editar / Atualizar
                    {
                    cepdao.atualizar(cpp);
                    title    = "Edição de registro";
                    msg      = "Deseja Reeditar o CEP abaixo de sua lista \\n \\n "+add;
                    }break;

                case 2: //Deletar/ Excluir
                    {
                    cepdao.deletar(cpp);
                    title    = "Exclusão de registro";
                    msg      = "Deseja APAGAR o CEP abaixo da sua lista \\n \\n "+add;
                    }break;
                }

            AlertDialog.Builder builder;

            builder = new AlertDialog.Builder(act);

            builder.setMessage(msg)
                   .setTitle(title)
                   .setCancelable(false)
                   .setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                             if(caso == 0)
                                {
                                cepdao.salvar(cpp);

                                OKDialog("OK","Registro salvo com sucesso!", act);
                                }
                             else if(caso == 1)
                                {
                                cepdao.atualizar(cpp);

                                OKDialog("OK","Registro alterado com sucesso!", act);
                                }
                             else if(caso == 2)
                                {
                                cepdao.deletar(cpp);

                                OKDialog("OK","Registro excluído com sucesso!", act);
                                }
                            }
                        })
                   .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                            }
                        });

            builder.show();
            /*
                //Creating dialog box
            AlertDialog alert = builder.create();
                //Setting the title manually

            alert.setTitle("AlertDialogExample");
            alert.show();//*/
            }

        public void OKDialog(String title, String msg, Activity act)
            {
                AlertDialog.Builder builder;

                builder = new AlertDialog.Builder(act);

                builder.setMessage(msg)
                        .setTitle(title)
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                builder.show();
            }
    }
