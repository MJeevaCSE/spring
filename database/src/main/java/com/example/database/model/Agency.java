package com.example.database.model;

    import jakarta.persistence.*;

    @Entity
    @Table(name ="agency")
    public class Agency{

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        @Column(name = "traveller_id")
        private String traveller_id;

        @Column(name = "traveller_mname")
        private String traveller_name;


        @Column(name = "booking_date")
        private String booking_date;

        @Column(name = "travelling_place")
        private String travelling_place;

        public Agency(){
            
        }

        
        public Agency(String traveller_id, String traveller_name, String booking_date, String travelling_place){
            this.traveller_id=traveller_id;
            this.traveller_name=traveller_name;
            this.booking_date=booking_date;
            this.travelling_place=travelling_place;
        }


        public long getId() {
            return id;
        }


        public void setId(long id) {
            this.id = id;
        }


        public String gettraveller_id() {
            return traveller_id;
        }


        public void settraveller_id(String traveller_id) {
            this.traveller_id = traveller_id;
        }


        public String gettraveller_name() {
            return traveller_name;
        }


        public void settraveller_name(String traveller_name) {
            this.traveller_name = traveller_name;
        }


        public String getbooking_date() {
            return booking_date;
        }


        public void setbooking_date(String booking_date) {
            this.booking_date = booking_date;
        }


        public String gettravelling_place() {
            return travelling_place;
        }


        public void settravelling_place(String travelling_place) {
            this.travelling_place = travelling_place;
        }

       @Override
       public String toString() {
        return "Agency [id=" + id +", traveller_id=" +traveller_id +", traveller_name=" + traveller_name +", booking_date=" + booking_date +", travelling_place=" + travelling_place+ "]";

       } 
    }