

document.addEventListener('DOMContentLoaded',()=>{

    if(!sessionStorage.getItem("cartItems")){
        const userID=sessionStorage.getItem("userID");
        fetch(`http://localhost:8080/getAllCartItems/${userID}`,{})
        .then(response=>{
    
            if(!response.ok){
                throw new error("Failed to fecth data from the user")
            }
       return response.json();
       
        }).then(data=>{


            console.log("cart items was not available/n"+data);
            displayAllCartItems(data);
            sessionStorage.setItem("cartItems",JSON.stringify(data));

        })
        .catch(error=>{
    
            console.log(error);
        });
        
    }else {

        const cartItems=JSON.parse(sessionStorage.getItem("cartItems"));
        console.log("cart items is available/n"+cartItems);

        displayAllCartItems(cartItems);
    }
});

const displayAllCartItems=(cartItems)=>{

    const container=document.getElementById("cart-container");

    
    const products=JSON.parse(sessionStorage.getItem("products"));

    cartItems.forEach(({quantity,productID,cartID})=>{


         const {prodID,imgSrc,price,name}=products.find(prod=> prod.productID==productID);
         const totalCartItem=quantity*price;
        const cartBox=document.createElement('div');
        cartBox.className="table-row custom-border mt-14";
        cartBox.innerHTML=
        `<div class='table-cell '><img class=' object-cover w-20 h-20' src='../images/${imgSrc}' alt='${name}'></div>
        <div class='table-cell  '>
        <div class='flex flex-col justify-center items-center pb-96'>
        <div class=''>${name}</div>
        <div class=' font-bold text-xl'>R ${totalCartItem}</div>
        </div>
        </div>
        <div class='table-cell w-64'>
       <div class='flex items-center justify-center'><button id=${cartID}  class='deleteBtn  cursor-pointer' ><i class="bi bi-trash3-fill"></i></button></div>
        </div>
        `;
        container.append(cartBox);
    });

const deleteEventListner=()=>{
    const deleteButtons=document.querySelectorAll('.deleteBtn');

    deleteButtons.forEach(button=>{

        button.addEventListener('click',()=>{

            
        location.reload();
        });
    });
}
   
}
const deleteEventListner=()=>{
    const deleteButtons=document.querySelectorAll('.deleteBtn');

    deleteButtons.forEach(button=>{

        button.addEventListener('click',()=>{

            const id= button.id;
            const wishlist=JSON.parse(sessionStorage.getItem('wishlist'));

        const newWishlist=  wishlist.filter(prod=> prod.productID!=id);
        sessionStorage.setItem('wishlist',JSON.stringify(newWishlist));
        location.reload();
        });
    });
}