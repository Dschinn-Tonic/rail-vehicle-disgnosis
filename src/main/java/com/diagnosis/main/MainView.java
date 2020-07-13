package com.diagnosis.main;

import org.springframework.beans.factory.annotation.Autowired;

import com.diagnosis.map.LeafletMap;
import com.diagnosis.map.LeafletMap.MarkerClickEvent;
import com.diagnosis.measurement.Measurement;
import com.diagnosis.serviceImpl.MapLocationService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * Main and only view in this app. Uses @LeafletMap and Vaadin components
 */
@Route("")
@PageTitle("Welcome to rail vehicle diagnosis")
public class MainView extends VerticalLayout {

	private static final long serialVersionUID = 1L;
	private static final String TITLE = "Welcome to rail vehicle diagnosis";
	private static final String SUBTITLE = "You can add a marker by clicking anywhere on the map.";

	private LeafletMap map;

	@Autowired
	public MainView(MapLocationService service) {
		setSizeFull();
		setPadding(false);
		setSpacing(false);

		showIntro();

		// Create the map and add it to this view
		map = new LeafletMap();
		map.setWidthFull();
		add(map);

		// Register for marker clicks
		map.addMarkerClickListener(this::markerClicked);

		// Add all known markers to the map
		map.addMarkersAndZoom(service.getAll());
	}

	private void showIntro() {
		H3 title = new H3(TITLE);
		Span subtitle = new Span(SUBTITLE);
		Button ok = new Button("OK!", VaadinIcon.CHECK.create());
		VerticalLayout titleLayout = new VerticalLayout(title, subtitle, ok);
		titleLayout.setPadding(false);

		Dialog introDialog = new Dialog(titleLayout);
		introDialog.open();

		ok.addClickListener(e -> introDialog.close());
	}

	private void markerClicked(MarkerClickEvent event) {
		Measurement measurement = event.getMarker();
		Label title = new Label("This is the diagnosis of " + measurement.getMeasuredName() + " at "
				+ measurement.getMapLocation().getName());
		Label subtitle = new Label();
		subtitle.getElement().setProperty("innerHTML",
				"Measurement reason: " + measurement.getReason().getMeasurementType().name
						+ "<br>Measured attributes: <br> " + "Max. acceleration value: "
						+ measurement.getMaxAccelerationValue() + "<br>Max. engine temperature: "
						+ measurement.getMaxEngineTemperature() + "<br>Max. braking Power: "
						+ measurement.getMaxBrakingPower());
		Button ok = new Button("OK!", VaadinIcon.CHECK.create());
		VerticalLayout titleLayout = new VerticalLayout(title, subtitle, ok);
		titleLayout.setPadding(false);
		Dialog diagnosisDialog = new Dialog(titleLayout);
		diagnosisDialog.open();

		ok.addClickListener(e -> diagnosisDialog.close());

	}
}
