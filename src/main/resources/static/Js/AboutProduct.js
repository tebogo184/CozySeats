

const container=document.getElementById('container');
const registerNavLink=document.getElementById("registerNavLink");
const loginNavLink=document.getElementById("loginNavLink");

loginNavLink.addEventListener("click",()=>{

    document.getElementById("login-box").classList.remove("hidden");
});

registerNavLink.addEventListener("click",()=>{

    document.getElementById("register-box").classList.remove("hidden");
});

document.addEventListener('DOMContentLoaded',()=>{

    
    const myKeyValues=window.location.search;
    const urlPramameter=new URLSearchParams(myKeyValues);

    

    const prodID=Number.parseInt(urlPramameter.get('id'));

    const productList=JSON.parse(sessionStorage.getItem('products'));

    const {imgSrc,name,description,price}= productList.find(product=> product.productID==prodID);
    
   

    container.innerHTML=
    `<div>
    <img src='../images/${imgSrc}'>
    </div>
    <div class='ml-5  p-4'>
    <div class='mt-4'>${name}</div>
    <div class='mt-4 '>${description}</div>
    <div class="mt-4 font-bold ">R ${price}</div>
    <button type='submit' id=${prodID} class='cartBtn  mt-8 border-2 h-9 rounded-md bg-green-700 border-green-700 text-white font-bold cursor-pointer w-72'
     id=${prodID}>
     Add To Cart
     </button>
    <button id=${prodID} class='wishlistBtn' ><i class="bi bi-heart" ></i></button>
    </div>`;

    addWishlistEventListener();
    addCartEventListner();
});

const addToCart= async (cartItem,userID)=>{


    try {
        
        const response=await fetch(`http://localhost:8080/addCartItem/${userID}`,{

            headers:{
                "Content-Type":"application/json"
            },
            method:"POST",
            body: JSON.stringify(cartItem)
        });

        if(!response.ok){

            throw new error("Failed to add item to the cart");
        }

        console.log("Item has been added Succesful");
        const data =await response.json();
        console.log(data)

        sessionStorage.removeItem("cartItems");
        sessionStorage.setItem("cartItems",JSON.stringify(data));
        console.log("sessionStorage:"+sessionStorage);
    } catch (error) {
        
        console.log(error);
    }
}

const addCartEventListner=()=>{

    const cartButtons=document.querySelectorAll(".cartBtn");

    cartButtons.forEach(button=>{

        button.addEventListener('click',()=>{
            
            const prodID= button.id;

            const userID=sessionStorage.getItem("userID");

            const cartItem=
            {

                productID:prodID,
                cartID:"",
                quantity:1

            }

            addToCart(cartItem,userID);


        });

    });
}
const addWishlistEventListener=()=>{

    const wishlistButtons=document.querySelectorAll('.wishlistBtn');

    wishlistButtons.forEach(button=>{

        button.addEventListener('click',()=>{

            const prodID=button.id;

            addProductToWishlist(prodID);

    
        });
    });

 }


const addProductToWishlist=(prodID)=>{

    const productList=JSON.parse(sessionStorage.getItem('products'));
    const product=productList.find(prod=> prod.productID==prodID);

    if(sessionStorage.getItem('wishlist')){
        const wishlist=JSON.parse(sessionStorage.getItem('wishlist'));

        if(!wishlist.find(prod=>prod.productID==prodID)){

            wishlist.push(product);

        }

    sessionStorage.setItem('wishlist',JSON.stringify(wishlist));
    

    }else{

        const wishlist=[];

        wishlist.push(product);

        sessionStorage.setItem('wishlist',JSON.stringify(wishlist));
        
    }

 }