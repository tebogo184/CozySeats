const submitBtn=document.getElementById("submit");

submitBtn.addEventListener('click',(e)=>{

    e.preventDefault();

    const submitForm=async ()=>{
       try {
        const userID=sessionStorage.getItem("userID");

        const response=await fetch(`http://localhost:8080/checkout/${userID}`,{

            headers: {
                'Content-Type': 'application/json'
            },
            method: 'POST',
            body:""
        });

        console.log(response);
        location.reload();
        if(!response.ok){
            throw new error("Could not clear the cart");
        }

        console.log("Cart has been cleared");
        
       } catch (error) {
        
        console.log(error);
       }



    }

    submitForm();
});