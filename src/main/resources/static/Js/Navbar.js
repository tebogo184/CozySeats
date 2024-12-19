




document.addEventListener("DOMContentLoaded",()=>{

    if(sessionStorage.getItem("userID")){

        document.getElementById("cartNavLink").classList.remove("hidden");
        document.getElementById("invoiceNavLink").classList.remove("hidden");
        document.getElementById("registerNavLink").classList.add("hidden");
        document.getElementById("loginNavLink").classList.add("hidden");


    }else {
        document.getElementById("cartNavLink").classList.add("hidden");
        document.getElementById("invoiceNavLink").classList.add("hidden");
        document.getElementById("registerNavLink").classList.remove("hidden");
        document.getElementById("loginNavLink").classList.remove("hidden");
    }
});