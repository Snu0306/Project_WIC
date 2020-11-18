package kr.or.wic.dto;

import java.util.Date;

public class MessageDTO {
   private int msg_num;
   private String msg_content;
   private String msg_date;
   private int ch_num;
   private String id;
   public int getMsg_num() {
      return msg_num;
   }
   public void setMsg_num(int msg_num) {
      this.msg_num = msg_num;
   }
   public String getMsg_content() {
      return msg_content;
   }
   public void setMsg_content(String msg_content) {
      this.msg_content = msg_content;
   }


   public String getMsg_date() {
      return msg_date;
   }
   public void setMsg_date(String msg_date) {
      this.msg_date = msg_date;
   }
   public int getCh_num() {
      return ch_num;
   }
   public void setCh_num(int ch_num) {
      this.ch_num = ch_num;
   }
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   @Override
   public String toString() {
      return "MessageDTO [msg_num=" + msg_num + ", msg_content=" + msg_content + ", msg_date=" + msg_date
            + ", ch_num=" + ch_num + ", id=" + id + "]";
   }
   
   
   
}