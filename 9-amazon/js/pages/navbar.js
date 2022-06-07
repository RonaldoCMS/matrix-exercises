"use strict";
document.write(`
<nav class="navbar-color">
<div class="container-fluid">
  <div class="row">
    <div class="col-md-2">
      <div class="navbar-header">
        <a class="navbar-brand sb_tgl" href="#"><div class="toggal_line"></div>
        <div class="toggal_line"></div><div class="toggal_line"></div>
        </a>
        <a class="navbar-brand sb_logo" href="#"><img src="assets/images/navbar/logo.png" alt="emart"></a>
      </div>
    </div>
    <div class="col-md-6">
      <form class="sb_search_bar" action="/action_page.php">
        <div class="input-group sb_search">
          <div class="input-group-btn search-panel">
              <button type="button" class="btn btn-default dropdown-toggle sb_search_drop search_drop_bg_color" data-toggle="dropdown">
                <span id="search_concept">All</span> <span class="caret"></span>
              </button>
              <ul class="dropdown-menu" role="menu">
                <li><a href="#contains">Example 1</a></li>
                <li><a href="#its_equal">Example 2</a></li>
                <li><a href="#greather_than">Example 3</a></li>
                <li><a href="#less_than">Example 4</a></li>
                <li class="divider"></li>
                <li><a href="#all">All</a></li>
              </ul>
          </div>
          <input type="hidden" name="search_param" value="all" id="search_param">         
          <input type="text" class="form-control sb_search_drop" name="x">
          <span class="input-group-btn search_btn_bg">
              <button class="btn btn-default sb_search_drop search_btn_bg" type="button"><span class="glyphicon glyphicon-search"></span></button>
          </span>
      </div>
      </form>
    </div>
    <div class="col-md-4">
      <div class="row">
        <div class="col-md-2">
          <div class="dropdown sb_lang_dd">
            <button class="dropbtn">
              <span class="icp-nav-flag icp-nav-flag-us"></span>
              <span><i class="fa fa-caret-down align"></i></span>
            </button>
            <div class="dropdown-content">
              <p class="p_change_lng">Change Language</p>
            </div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="signin_block">
          <div class="signup_account">
            <span class="acc_txt_1">Hello, Sign in</span>
            <span class="acc_txt_2">Account &amp; Lists<i class="fa fa-caret-down align"></i></span>
            
          </div>
          <div class="signup_content_card card">
            <a class="signin_link" rel="nofollow">
            <span class="sign_in_btn">Sign In</span></a>
            <div class="new_cus_p">
            New customer? <a>Start here.</a>
            </div>
            <div class="row signin_cln_padding">
              <div class="col-md-6">
                <div class="signin_clm_heading">Your Lists</div>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">Create a List</span></a>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">Find a List or Registry</span></a>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">Find a Gift</span></a>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">Save Items from the Web</span></a>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">Wedding Registry</span></a>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">Baby Registry</span></a>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">Friends &amp; Family Gifting</span></a>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">AmazonSmile Charity Lists</span></a>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">Pantry Lists</span></a>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">Your Hearts</span></a>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">Explore Idea Lists</span></a>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">Explore Showroom</span></a>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">Take the Home Style Quiz</span></a>
                
              </div>
              <div class="col-md-6">
                <div class="signin_clm_heading">Your Account</div>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">Your Account</span></a>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">Your Orders</span></a>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">Your Recommendations</span></a>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">Your Subscribe &amp; Save Items</span></a>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">Memberships &amp; Subscriptions</span></a>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">Your Service Requests</span></a>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">Your Garage</span></a>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">Your Fanshop</span></a>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">Your Pets</span></a>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">Your Content and Devices</span></a>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">Your Music Library</span></a>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">Your Amazon Drive</span></a>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">Your Prime Video</span></a>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">Your Kindle Unlimited</span></a>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">Your Watchlist</span></a>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">Your Video Purchases &amp; Rentals</span></a>
                <a href="#" class="signin_clm_link"><span class="link_signin_text">Your Android Apps &amp; Devices</span></a>
              </div>
            </div>
          </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="return_div">
            <span class="acc_txt_1 ">Returns</span><br>
            <span class="acc_txt_2 ">&amp; Orders</span>
          </div>
        </div>
        <div class="col-md-3">
          <div class="cart_icon_div">
            
            <div class="cart_icon"></div>
            <span class="cart_txt_2">Cart</span>
            <span id="nav-cart-count" aria-hidden="true" class="nav-cart-count nav-cart-0">0</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</nav>
<nav class="second_nav">
<div class="container-fluid">
  <div class="row">
    <div class="col-md-1">
      <div class="loc_div">
        <div class="location_icon"></div>
        <span class="acc_txt_1 loc_text">Deliver to</span>
        <span class="acc_txt_2 loc_text">India</span>
      </div>
    </div>
    <div class="col-md-1"></div>
    <div class="col-md-7">
      <div class="s_nav_links">
        <a class="s_links" href="#">Today's Deals</a>
        <a class="s_links" href="#">Customer Service</a>
        <a class="s_links" href="#">Gift Cards</a>
        <a class="s_links" href="#">Registry</a>
        <a class="s_links" href="#">Sell</a>
      </div>
    </div>
    <div class="col-md-3">
      <div class="s_msg_div">
        <a class="s_msg_link" href="#">Amazon's response to COVID-19</a>
      </div>
    </div>
  </div>
</div>
</nav> 
`);
