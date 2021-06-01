package com.example.communitywatermis;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        ImageSlider imageSlider=findViewById(R.id.slider);

        ImageSlider imageSlider2=findViewById(R.id.slider2);

        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel("https://www.nairobiwater.co.ke/components/com_eventgallery/helpers/image.php?option=com_eventgallery&mode=full&view=resizeimage&folder=Facilities&file=1.JPG","Image 1"));
        slideModels.add(new SlideModel("https://www.nairobiwater.co.ke/components/com_eventgallery/helpers/image.php?option=com_eventgallery&mode=full&view=resizeimage&folder=Facilities&file=10.jpg","Image 2"));
        slideModels.add(new SlideModel("https://www.nairobiwater.co.ke/components/com_eventgallery/helpers/image.php?option=com_eventgallery&mode=full&view=resizeimage&folder=Facilities&file=8.JPG","Image 3"));
        slideModels.add(new SlideModel("https://www.nairobiwater.co.ke/components/com_eventgallery/helpers/image.php?option=com_eventgallery&mode=full&view=resizeimage&folder=Facilities&file=7.JPG","Image 4"));
        slideModels.add(new SlideModel("https://www.nairobiwater.co.ke/components/com_eventgallery/helpers/image.php?option=com_eventgallery&mode=full&view=resizeimage&folder=Facilities&file=5.JPG","Image 5"));
        imageSlider.setImageList(slideModels,true);


        List<SlideModel> slideModels1=new ArrayList<>();
        slideModels1.add(new SlideModel("https://www.nairobiwater.co.ke/components/com_eventgallery/helpers/image.php?option=com_eventgallery&mode=full&view=resizeimage&folder=Events&file=DSC_0070.JPG","President Uhuru Kenyatta hands over Rapid Results Initiative booklet to Ag. NCWSC MD"));
        slideModels1.add(new SlideModel("https://www.nairobiwater.co.ke/components/com_eventgallery/helpers/image.php?option=com_eventgallery&mode=full&view=resizeimage&folder=Events&file=DSC_0184.JPG","Kenya County Government Workers Union Chairman Fred Buluku leads the staff in marking this year’s Labor Day "));
        slideModels1.add(new SlideModel("https://www.nairobiwater.co.ke/components/com_eventgallery/helpers/image.php?option=com_eventgallery&mode=full&view=resizeimage&folder=Events&file=DSC_0566.JPG","Nairobi County Water and Sanitation Committee pose for a photo with staff at Ruiru Dam."));
        slideModels1.add(new SlideModel("https://www.nairobiwater.co.ke/components/com_eventgallery/helpers/image.php?option=com_eventgallery&mode=full&view=resizeimage&folder=Events&file=12.jpg","Young Water Professionals leadership pose for a photo at NCWSC Headquarters, Kampala Road"));
        slideModels1.add(new SlideModel("https://www.nairobiwater.co.ke/components/com_eventgallery/helpers/image.php?option=com_eventgallery&mode=full&view=resizeimage&folder=Events&file=Optimized-DSC_0084.JPG","NCWSC staff demonstrates the water treatment process at Ngethu Treatment Works"));
        imageSlider2.setImageList(slideModels1,true);
    }
}