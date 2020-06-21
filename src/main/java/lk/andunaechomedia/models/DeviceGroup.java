package lk.andunaechomedia.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "device_group")
@Getter
@Setter
public class DeviceGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    public DeviceGroup() {
    }

    public DeviceGroup(String groupId) {
        this.groupId=groupId;
    }

    @Id
    private String groupId;
    private String groupName;
   @JsonBackReference (value = "Device-DeviceGroup")
    @OneToMany(mappedBy = "deviceGroup", cascade = {
            CascadeType.ALL
    })
    private Set<Device> devices;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "main_schedule_id")
    private MainSchedule mainSchedule;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "temp_schedule_schedule_id")
//    private TempSchedule tempSchedule;
//
//    public TempSchedule getTempSchedule() {
//        return tempSchedule;
//    }
//
//    public void setTempSchedule(TempSchedule tempSchedule) {
//        this.tempSchedule = tempSchedule;
//    }




}