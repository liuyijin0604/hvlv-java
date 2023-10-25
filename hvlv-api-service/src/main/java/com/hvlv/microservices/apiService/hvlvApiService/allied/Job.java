/**
 * Job.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hvlv.microservices.apiService.hvlvApiService.allied;

public class Job  implements java.io.Serializable {
    private com.hvlv.microservices.apiService.hvlvApiService.allied.Account account;

    private java.lang.String bookedBy;

    private java.util.Calendar bookedDate;

    private java.util.Calendar cancelledDate;

    private java.util.Calendar chargedDate;

    private java.lang.String closeTime;

    private com.hvlv.microservices.apiService.hvlvApiService.allied.CubedItem[] cubedItems;

    private double cubicWeight;

    private java.util.Calendar deliveryDate;

    private java.util.Calendar dispatchedDate;

    private java.lang.String docketNumber;

    private java.lang.String instructions;

    private int itemCount;

    private com.hvlv.microservices.apiService.hvlvApiService.allied.Item[] items;

    private com.hvlv.microservices.apiService.hvlvApiService.allied.JobError[] jobErrors;

    private com.hvlv.microservices.apiService.hvlvApiService.allied.Note[] jobNotes;

    private int jobNumber;

    private java.lang.String jobStatus;

    private com.hvlv.microservices.apiService.hvlvApiService.allied.JobStop[] jobStops;

    private java.lang.String jobType;

    private java.lang.String notes;

    private java.util.Calendar pickupDate;

    private com.hvlv.microservices.apiService.hvlvApiService.allied.POD[] pods;

    private com.hvlv.microservices.apiService.hvlvApiService.allied.Price price;

    private java.util.Calendar readyDate;

    private java.lang.String[] referenceNumbers;

    private com.hvlv.microservices.apiService.hvlvApiService.allied.Scanning[] scannings;

    private java.util.Calendar scheduledDeliveryDate;

    private java.util.Calendar scheduledPickupDate;

    private java.lang.String serviceDescription;

    private java.lang.String serviceLevel;

    private com.hvlv.microservices.apiService.hvlvApiService.allied.ElectronicSignature[] signatures;

    private java.lang.String validatedHash;

    private com.hvlv.microservices.apiService.hvlvApiService.allied.Vehicle vehicle;

    private double volume;

    private double weight;

    public Job() {
    }

    public Job(
           com.hvlv.microservices.apiService.hvlvApiService.allied.Account account,
           java.lang.String bookedBy,
           java.util.Calendar bookedDate,
           java.util.Calendar cancelledDate,
           java.util.Calendar chargedDate,
           java.lang.String closeTime,
           com.hvlv.microservices.apiService.hvlvApiService.allied.CubedItem[] cubedItems,
           double cubicWeight,
           java.util.Calendar deliveryDate,
           java.util.Calendar dispatchedDate,
           java.lang.String docketNumber,
           java.lang.String instructions,
           int itemCount,
           com.hvlv.microservices.apiService.hvlvApiService.allied.Item[] items,
           com.hvlv.microservices.apiService.hvlvApiService.allied.JobError[] jobErrors,
           com.hvlv.microservices.apiService.hvlvApiService.allied.Note[] jobNotes,
           int jobNumber,
           java.lang.String jobStatus,
           com.hvlv.microservices.apiService.hvlvApiService.allied.JobStop[] jobStops,
           java.lang.String jobType,
           java.lang.String notes,
           java.util.Calendar pickupDate,
           com.hvlv.microservices.apiService.hvlvApiService.allied.POD[] pods,
           com.hvlv.microservices.apiService.hvlvApiService.allied.Price price,
           java.util.Calendar readyDate,
           java.lang.String[] referenceNumbers,
           com.hvlv.microservices.apiService.hvlvApiService.allied.Scanning[] scannings,
           java.util.Calendar scheduledDeliveryDate,
           java.util.Calendar scheduledPickupDate,
           java.lang.String serviceDescription,
           java.lang.String serviceLevel,
           com.hvlv.microservices.apiService.hvlvApiService.allied.ElectronicSignature[] signatures,
           java.lang.String validatedHash,
           com.hvlv.microservices.apiService.hvlvApiService.allied.Vehicle vehicle,
           double volume,
           double weight) {
           this.account = account;
           this.bookedBy = bookedBy;
           this.bookedDate = bookedDate;
           this.cancelledDate = cancelledDate;
           this.chargedDate = chargedDate;
           this.closeTime = closeTime;
           this.cubedItems = cubedItems;
           this.cubicWeight = cubicWeight;
           this.deliveryDate = deliveryDate;
           this.dispatchedDate = dispatchedDate;
           this.docketNumber = docketNumber;
           this.instructions = instructions;
           this.itemCount = itemCount;
           this.items = items;
           this.jobErrors = jobErrors;
           this.jobNotes = jobNotes;
           this.jobNumber = jobNumber;
           this.jobStatus = jobStatus;
           this.jobStops = jobStops;
           this.jobType = jobType;
           this.notes = notes;
           this.pickupDate = pickupDate;
           this.pods = pods;
           this.price = price;
           this.readyDate = readyDate;
           this.referenceNumbers = referenceNumbers;
           this.scannings = scannings;
           this.scheduledDeliveryDate = scheduledDeliveryDate;
           this.scheduledPickupDate = scheduledPickupDate;
           this.serviceDescription = serviceDescription;
           this.serviceLevel = serviceLevel;
           this.signatures = signatures;
           this.validatedHash = validatedHash;
           this.vehicle = vehicle;
           this.volume = volume;
           this.weight = weight;
    }


    /**
     * Gets the account value for this Job.
     * 
     * @return account
     */
    public com.hvlv.microservices.apiService.hvlvApiService.allied.Account getAccount() {
        return account;
    }


    /**
     * Sets the account value for this Job.
     * 
     * @param account
     */
    public void setAccount(com.hvlv.microservices.apiService.hvlvApiService.allied.Account account) {
        this.account = account;
    }


    /**
     * Gets the bookedBy value for this Job.
     * 
     * @return bookedBy
     */
    public java.lang.String getBookedBy() {
        return bookedBy;
    }


    /**
     * Sets the bookedBy value for this Job.
     * 
     * @param bookedBy
     */
    public void setBookedBy(java.lang.String bookedBy) {
        this.bookedBy = bookedBy;
    }


    /**
     * Gets the bookedDate value for this Job.
     * 
     * @return bookedDate
     */
    public java.util.Calendar getBookedDate() {
        return bookedDate;
    }


    /**
     * Sets the bookedDate value for this Job.
     * 
     * @param bookedDate
     */
    public void setBookedDate(java.util.Calendar bookedDate) {
        this.bookedDate = bookedDate;
    }


    /**
     * Gets the cancelledDate value for this Job.
     * 
     * @return cancelledDate
     */
    public java.util.Calendar getCancelledDate() {
        return cancelledDate;
    }


    /**
     * Sets the cancelledDate value for this Job.
     * 
     * @param cancelledDate
     */
    public void setCancelledDate(java.util.Calendar cancelledDate) {
        this.cancelledDate = cancelledDate;
    }


    /**
     * Gets the chargedDate value for this Job.
     * 
     * @return chargedDate
     */
    public java.util.Calendar getChargedDate() {
        return chargedDate;
    }


    /**
     * Sets the chargedDate value for this Job.
     * 
     * @param chargedDate
     */
    public void setChargedDate(java.util.Calendar chargedDate) {
        this.chargedDate = chargedDate;
    }


    /**
     * Gets the closeTime value for this Job.
     * 
     * @return closeTime
     */
    public java.lang.String getCloseTime() {
        return closeTime;
    }


    /**
     * Sets the closeTime value for this Job.
     * 
     * @param closeTime
     */
    public void setCloseTime(java.lang.String closeTime) {
        this.closeTime = closeTime;
    }


    /**
     * Gets the cubedItems value for this Job.
     * 
     * @return cubedItems
     */
    public com.hvlv.microservices.apiService.hvlvApiService.allied.CubedItem[] getCubedItems() {
        return cubedItems;
    }


    /**
     * Sets the cubedItems value for this Job.
     * 
     * @param cubedItems
     */
    public void setCubedItems(com.hvlv.microservices.apiService.hvlvApiService.allied.CubedItem[] cubedItems) {
        this.cubedItems = cubedItems;
    }

    public com.hvlv.microservices.apiService.hvlvApiService.allied.CubedItem getCubedItems(int i) {
        return this.cubedItems[i];
    }

    public void setCubedItems(int i, com.hvlv.microservices.apiService.hvlvApiService.allied.CubedItem _value) {
        this.cubedItems[i] = _value;
    }


    /**
     * Gets the cubicWeight value for this Job.
     * 
     * @return cubicWeight
     */
    public double getCubicWeight() {
        return cubicWeight;
    }


    /**
     * Sets the cubicWeight value for this Job.
     * 
     * @param cubicWeight
     */
    public void setCubicWeight(double cubicWeight) {
        this.cubicWeight = cubicWeight;
    }


    /**
     * Gets the deliveryDate value for this Job.
     * 
     * @return deliveryDate
     */
    public java.util.Calendar getDeliveryDate() {
        return deliveryDate;
    }


    /**
     * Sets the deliveryDate value for this Job.
     * 
     * @param deliveryDate
     */
    public void setDeliveryDate(java.util.Calendar deliveryDate) {
        this.deliveryDate = deliveryDate;
    }


    /**
     * Gets the dispatchedDate value for this Job.
     * 
     * @return dispatchedDate
     */
    public java.util.Calendar getDispatchedDate() {
        return dispatchedDate;
    }


    /**
     * Sets the dispatchedDate value for this Job.
     * 
     * @param dispatchedDate
     */
    public void setDispatchedDate(java.util.Calendar dispatchedDate) {
        this.dispatchedDate = dispatchedDate;
    }


    /**
     * Gets the docketNumber value for this Job.
     * 
     * @return docketNumber
     */
    public java.lang.String getDocketNumber() {
        return docketNumber;
    }


    /**
     * Sets the docketNumber value for this Job.
     * 
     * @param docketNumber
     */
    public void setDocketNumber(java.lang.String docketNumber) {
        this.docketNumber = docketNumber;
    }


    /**
     * Gets the instructions value for this Job.
     * 
     * @return instructions
     */
    public java.lang.String getInstructions() {
        return instructions;
    }


    /**
     * Sets the instructions value for this Job.
     * 
     * @param instructions
     */
    public void setInstructions(java.lang.String instructions) {
        this.instructions = instructions;
    }


    /**
     * Gets the itemCount value for this Job.
     * 
     * @return itemCount
     */
    public int getItemCount() {
        return itemCount;
    }


    /**
     * Sets the itemCount value for this Job.
     * 
     * @param itemCount
     */
    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }


    /**
     * Gets the items value for this Job.
     * 
     * @return items
     */
    public com.hvlv.microservices.apiService.hvlvApiService.allied.Item[] getItems() {
        return items;
    }


    /**
     * Sets the items value for this Job.
     * 
     * @param items
     */
    public void setItems(com.hvlv.microservices.apiService.hvlvApiService.allied.Item[] items) {
        this.items = items;
    }

    public com.hvlv.microservices.apiService.hvlvApiService.allied.Item getItems(int i) {
        return this.items[i];
    }

    public void setItems(int i, com.hvlv.microservices.apiService.hvlvApiService.allied.Item _value) {
        this.items[i] = _value;
    }


    /**
     * Gets the jobErrors value for this Job.
     * 
     * @return jobErrors
     */
    public com.hvlv.microservices.apiService.hvlvApiService.allied.JobError[] getJobErrors() {
        return jobErrors;
    }


    /**
     * Sets the jobErrors value for this Job.
     * 
     * @param jobErrors
     */
    public void setJobErrors(com.hvlv.microservices.apiService.hvlvApiService.allied.JobError[] jobErrors) {
        this.jobErrors = jobErrors;
    }

    public com.hvlv.microservices.apiService.hvlvApiService.allied.JobError getJobErrors(int i) {
        return this.jobErrors[i];
    }

    public void setJobErrors(int i, com.hvlv.microservices.apiService.hvlvApiService.allied.JobError _value) {
        this.jobErrors[i] = _value;
    }


    /**
     * Gets the jobNotes value for this Job.
     * 
     * @return jobNotes
     */
    public com.hvlv.microservices.apiService.hvlvApiService.allied.Note[] getJobNotes() {
        return jobNotes;
    }


    /**
     * Sets the jobNotes value for this Job.
     * 
     * @param jobNotes
     */
    public void setJobNotes(com.hvlv.microservices.apiService.hvlvApiService.allied.Note[] jobNotes) {
        this.jobNotes = jobNotes;
    }

    public com.hvlv.microservices.apiService.hvlvApiService.allied.Note getJobNotes(int i) {
        return this.jobNotes[i];
    }

    public void setJobNotes(int i, com.hvlv.microservices.apiService.hvlvApiService.allied.Note _value) {
        this.jobNotes[i] = _value;
    }


    /**
     * Gets the jobNumber value for this Job.
     * 
     * @return jobNumber
     */
    public int getJobNumber() {
        return jobNumber;
    }


    /**
     * Sets the jobNumber value for this Job.
     * 
     * @param jobNumber
     */
    public void setJobNumber(int jobNumber) {
        this.jobNumber = jobNumber;
    }


    /**
     * Gets the jobStatus value for this Job.
     * 
     * @return jobStatus
     */
    public java.lang.String getJobStatus() {
        return jobStatus;
    }


    /**
     * Sets the jobStatus value for this Job.
     * 
     * @param jobStatus
     */
    public void setJobStatus(java.lang.String jobStatus) {
        this.jobStatus = jobStatus;
    }


    /**
     * Gets the jobStops value for this Job.
     * 
     * @return jobStops
     */
    public com.hvlv.microservices.apiService.hvlvApiService.allied.JobStop[] getJobStops() {
        return jobStops;
    }


    /**
     * Sets the jobStops value for this Job.
     * 
     * @param jobStops
     */
    public void setJobStops(com.hvlv.microservices.apiService.hvlvApiService.allied.JobStop[] jobStops) {
        this.jobStops = jobStops;
    }

    public com.hvlv.microservices.apiService.hvlvApiService.allied.JobStop getJobStops(int i) {
        return this.jobStops[i];
    }

    public void setJobStops(int i, com.hvlv.microservices.apiService.hvlvApiService.allied.JobStop _value) {
        this.jobStops[i] = _value;
    }


    /**
     * Gets the jobType value for this Job.
     * 
     * @return jobType
     */
    public java.lang.String getJobType() {
        return jobType;
    }


    /**
     * Sets the jobType value for this Job.
     * 
     * @param jobType
     */
    public void setJobType(java.lang.String jobType) {
        this.jobType = jobType;
    }


    /**
     * Gets the notes value for this Job.
     * 
     * @return notes
     */
    public java.lang.String getNotes() {
        return notes;
    }


    /**
     * Sets the notes value for this Job.
     * 
     * @param notes
     */
    public void setNotes(java.lang.String notes) {
        this.notes = notes;
    }


    /**
     * Gets the pickupDate value for this Job.
     * 
     * @return pickupDate
     */
    public java.util.Calendar getPickupDate() {
        return pickupDate;
    }


    /**
     * Sets the pickupDate value for this Job.
     * 
     * @param pickupDate
     */
    public void setPickupDate(java.util.Calendar pickupDate) {
        this.pickupDate = pickupDate;
    }


    /**
     * Gets the pods value for this Job.
     * 
     * @return pods
     */
    public com.hvlv.microservices.apiService.hvlvApiService.allied.POD[] getPods() {
        return pods;
    }


    /**
     * Sets the pods value for this Job.
     * 
     * @param pods
     */
    public void setPods(com.hvlv.microservices.apiService.hvlvApiService.allied.POD[] pods) {
        this.pods = pods;
    }

    public com.hvlv.microservices.apiService.hvlvApiService.allied.POD getPods(int i) {
        return this.pods[i];
    }

    public void setPods(int i, com.hvlv.microservices.apiService.hvlvApiService.allied.POD _value) {
        this.pods[i] = _value;
    }


    /**
     * Gets the price value for this Job.
     * 
     * @return price
     */
    public com.hvlv.microservices.apiService.hvlvApiService.allied.Price getPrice() {
        return price;
    }


    /**
     * Sets the price value for this Job.
     * 
     * @param price
     */
    public void setPrice(com.hvlv.microservices.apiService.hvlvApiService.allied.Price price) {
        this.price = price;
    }


    /**
     * Gets the readyDate value for this Job.
     * 
     * @return readyDate
     */
    public java.util.Calendar getReadyDate() {
        return readyDate;
    }


    /**
     * Sets the readyDate value for this Job.
     * 
     * @param readyDate
     */
    public void setReadyDate(java.util.Calendar readyDate) {
        this.readyDate = readyDate;
    }


    /**
     * Gets the referenceNumbers value for this Job.
     * 
     * @return referenceNumbers
     */
    public java.lang.String[] getReferenceNumbers() {
        return referenceNumbers;
    }


    /**
     * Sets the referenceNumbers value for this Job.
     * 
     * @param referenceNumbers
     */
    public void setReferenceNumbers(java.lang.String[] referenceNumbers) {
        this.referenceNumbers = referenceNumbers;
    }

    public java.lang.String getReferenceNumbers(int i) {
        return this.referenceNumbers[i];
    }

    public void setReferenceNumbers(int i, java.lang.String _value) {
        this.referenceNumbers[i] = _value;
    }


    /**
     * Gets the scannings value for this Job.
     * 
     * @return scannings
     */
    public com.hvlv.microservices.apiService.hvlvApiService.allied.Scanning[] getScannings() {
        return scannings;
    }


    /**
     * Sets the scannings value for this Job.
     * 
     * @param scannings
     */
    public void setScannings(com.hvlv.microservices.apiService.hvlvApiService.allied.Scanning[] scannings) {
        this.scannings = scannings;
    }

    public com.hvlv.microservices.apiService.hvlvApiService.allied.Scanning getScannings(int i) {
        return this.scannings[i];
    }

    public void setScannings(int i, com.hvlv.microservices.apiService.hvlvApiService.allied.Scanning _value) {
        this.scannings[i] = _value;
    }


    /**
     * Gets the scheduledDeliveryDate value for this Job.
     * 
     * @return scheduledDeliveryDate
     */
    public java.util.Calendar getScheduledDeliveryDate() {
        return scheduledDeliveryDate;
    }


    /**
     * Sets the scheduledDeliveryDate value for this Job.
     * 
     * @param scheduledDeliveryDate
     */
    public void setScheduledDeliveryDate(java.util.Calendar scheduledDeliveryDate) {
        this.scheduledDeliveryDate = scheduledDeliveryDate;
    }


    /**
     * Gets the scheduledPickupDate value for this Job.
     * 
     * @return scheduledPickupDate
     */
    public java.util.Calendar getScheduledPickupDate() {
        return scheduledPickupDate;
    }


    /**
     * Sets the scheduledPickupDate value for this Job.
     * 
     * @param scheduledPickupDate
     */
    public void setScheduledPickupDate(java.util.Calendar scheduledPickupDate) {
        this.scheduledPickupDate = scheduledPickupDate;
    }


    /**
     * Gets the serviceDescription value for this Job.
     * 
     * @return serviceDescription
     */
    public java.lang.String getServiceDescription() {
        return serviceDescription;
    }


    /**
     * Sets the serviceDescription value for this Job.
     * 
     * @param serviceDescription
     */
    public void setServiceDescription(java.lang.String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }


    /**
     * Gets the serviceLevel value for this Job.
     * 
     * @return serviceLevel
     */
    public java.lang.String getServiceLevel() {
        return serviceLevel;
    }


    /**
     * Sets the serviceLevel value for this Job.
     * 
     * @param serviceLevel
     */
    public void setServiceLevel(java.lang.String serviceLevel) {
        this.serviceLevel = serviceLevel;
    }


    /**
     * Gets the signatures value for this Job.
     * 
     * @return signatures
     */
    public com.hvlv.microservices.apiService.hvlvApiService.allied.ElectronicSignature[] getSignatures() {
        return signatures;
    }


    /**
     * Sets the signatures value for this Job.
     * 
     * @param signatures
     */
    public void setSignatures(com.hvlv.microservices.apiService.hvlvApiService.allied.ElectronicSignature[] signatures) {
        this.signatures = signatures;
    }

    public com.hvlv.microservices.apiService.hvlvApiService.allied.ElectronicSignature getSignatures(int i) {
        return this.signatures[i];
    }

    public void setSignatures(int i, com.hvlv.microservices.apiService.hvlvApiService.allied.ElectronicSignature _value) {
        this.signatures[i] = _value;
    }


    /**
     * Gets the validatedHash value for this Job.
     * 
     * @return validatedHash
     */
    public java.lang.String getValidatedHash() {
        return validatedHash;
    }


    /**
     * Sets the validatedHash value for this Job.
     * 
     * @param validatedHash
     */
    public void setValidatedHash(java.lang.String validatedHash) {
        this.validatedHash = validatedHash;
    }


    /**
     * Gets the vehicle value for this Job.
     * 
     * @return vehicle
     */
    public com.hvlv.microservices.apiService.hvlvApiService.allied.Vehicle getVehicle() {
        return vehicle;
    }


    /**
     * Sets the vehicle value for this Job.
     * 
     * @param vehicle
     */
    public void setVehicle(com.hvlv.microservices.apiService.hvlvApiService.allied.Vehicle vehicle) {
        this.vehicle = vehicle;
    }


    /**
     * Gets the volume value for this Job.
     * 
     * @return volume
     */
    public double getVolume() {
        return volume;
    }


    /**
     * Sets the volume value for this Job.
     * 
     * @param volume
     */
    public void setVolume(double volume) {
        this.volume = volume;
    }


    /**
     * Gets the weight value for this Job.
     * 
     * @return weight
     */
    public double getWeight() {
        return weight;
    }


    /**
     * Sets the weight value for this Job.
     * 
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Job)) return false;
        Job other = (Job) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.account==null && other.getAccount()==null) || 
             (this.account!=null &&
              this.account.equals(other.getAccount()))) &&
            ((this.bookedBy==null && other.getBookedBy()==null) || 
             (this.bookedBy!=null &&
              this.bookedBy.equals(other.getBookedBy()))) &&
            ((this.bookedDate==null && other.getBookedDate()==null) || 
             (this.bookedDate!=null &&
              this.bookedDate.equals(other.getBookedDate()))) &&
            ((this.cancelledDate==null && other.getCancelledDate()==null) || 
             (this.cancelledDate!=null &&
              this.cancelledDate.equals(other.getCancelledDate()))) &&
            ((this.chargedDate==null && other.getChargedDate()==null) || 
             (this.chargedDate!=null &&
              this.chargedDate.equals(other.getChargedDate()))) &&
            ((this.closeTime==null && other.getCloseTime()==null) || 
             (this.closeTime!=null &&
              this.closeTime.equals(other.getCloseTime()))) &&
            ((this.cubedItems==null && other.getCubedItems()==null) || 
             (this.cubedItems!=null &&
              java.util.Arrays.equals(this.cubedItems, other.getCubedItems()))) &&
            this.cubicWeight == other.getCubicWeight() &&
            ((this.deliveryDate==null && other.getDeliveryDate()==null) || 
             (this.deliveryDate!=null &&
              this.deliveryDate.equals(other.getDeliveryDate()))) &&
            ((this.dispatchedDate==null && other.getDispatchedDate()==null) || 
             (this.dispatchedDate!=null &&
              this.dispatchedDate.equals(other.getDispatchedDate()))) &&
            ((this.docketNumber==null && other.getDocketNumber()==null) || 
             (this.docketNumber!=null &&
              this.docketNumber.equals(other.getDocketNumber()))) &&
            ((this.instructions==null && other.getInstructions()==null) || 
             (this.instructions!=null &&
              this.instructions.equals(other.getInstructions()))) &&
            this.itemCount == other.getItemCount() &&
            ((this.items==null && other.getItems()==null) || 
             (this.items!=null &&
              java.util.Arrays.equals(this.items, other.getItems()))) &&
            ((this.jobErrors==null && other.getJobErrors()==null) || 
             (this.jobErrors!=null &&
              java.util.Arrays.equals(this.jobErrors, other.getJobErrors()))) &&
            ((this.jobNotes==null && other.getJobNotes()==null) || 
             (this.jobNotes!=null &&
              java.util.Arrays.equals(this.jobNotes, other.getJobNotes()))) &&
            this.jobNumber == other.getJobNumber() &&
            ((this.jobStatus==null && other.getJobStatus()==null) || 
             (this.jobStatus!=null &&
              this.jobStatus.equals(other.getJobStatus()))) &&
            ((this.jobStops==null && other.getJobStops()==null) || 
             (this.jobStops!=null &&
              java.util.Arrays.equals(this.jobStops, other.getJobStops()))) &&
            ((this.jobType==null && other.getJobType()==null) || 
             (this.jobType!=null &&
              this.jobType.equals(other.getJobType()))) &&
            ((this.notes==null && other.getNotes()==null) || 
             (this.notes!=null &&
              this.notes.equals(other.getNotes()))) &&
            ((this.pickupDate==null && other.getPickupDate()==null) || 
             (this.pickupDate!=null &&
              this.pickupDate.equals(other.getPickupDate()))) &&
            ((this.pods==null && other.getPods()==null) || 
             (this.pods!=null &&
              java.util.Arrays.equals(this.pods, other.getPods()))) &&
            ((this.price==null && other.getPrice()==null) || 
             (this.price!=null &&
              this.price.equals(other.getPrice()))) &&
            ((this.readyDate==null && other.getReadyDate()==null) || 
             (this.readyDate!=null &&
              this.readyDate.equals(other.getReadyDate()))) &&
            ((this.referenceNumbers==null && other.getReferenceNumbers()==null) || 
             (this.referenceNumbers!=null &&
              java.util.Arrays.equals(this.referenceNumbers, other.getReferenceNumbers()))) &&
            ((this.scannings==null && other.getScannings()==null) || 
             (this.scannings!=null &&
              java.util.Arrays.equals(this.scannings, other.getScannings()))) &&
            ((this.scheduledDeliveryDate==null && other.getScheduledDeliveryDate()==null) || 
             (this.scheduledDeliveryDate!=null &&
              this.scheduledDeliveryDate.equals(other.getScheduledDeliveryDate()))) &&
            ((this.scheduledPickupDate==null && other.getScheduledPickupDate()==null) || 
             (this.scheduledPickupDate!=null &&
              this.scheduledPickupDate.equals(other.getScheduledPickupDate()))) &&
            ((this.serviceDescription==null && other.getServiceDescription()==null) || 
             (this.serviceDescription!=null &&
              this.serviceDescription.equals(other.getServiceDescription()))) &&
            ((this.serviceLevel==null && other.getServiceLevel()==null) || 
             (this.serviceLevel!=null &&
              this.serviceLevel.equals(other.getServiceLevel()))) &&
            ((this.signatures==null && other.getSignatures()==null) || 
             (this.signatures!=null &&
              java.util.Arrays.equals(this.signatures, other.getSignatures()))) &&
            ((this.validatedHash==null && other.getValidatedHash()==null) || 
             (this.validatedHash!=null &&
              this.validatedHash.equals(other.getValidatedHash()))) &&
            ((this.vehicle==null && other.getVehicle()==null) || 
             (this.vehicle!=null &&
              this.vehicle.equals(other.getVehicle()))) &&
            this.volume == other.getVolume() &&
            this.weight == other.getWeight();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAccount() != null) {
            _hashCode += getAccount().hashCode();
        }
        if (getBookedBy() != null) {
            _hashCode += getBookedBy().hashCode();
        }
        if (getBookedDate() != null) {
            _hashCode += getBookedDate().hashCode();
        }
        if (getCancelledDate() != null) {
            _hashCode += getCancelledDate().hashCode();
        }
        if (getChargedDate() != null) {
            _hashCode += getChargedDate().hashCode();
        }
        if (getCloseTime() != null) {
            _hashCode += getCloseTime().hashCode();
        }
        if (getCubedItems() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCubedItems());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCubedItems(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Double(getCubicWeight()).hashCode();
        if (getDeliveryDate() != null) {
            _hashCode += getDeliveryDate().hashCode();
        }
        if (getDispatchedDate() != null) {
            _hashCode += getDispatchedDate().hashCode();
        }
        if (getDocketNumber() != null) {
            _hashCode += getDocketNumber().hashCode();
        }
        if (getInstructions() != null) {
            _hashCode += getInstructions().hashCode();
        }
        _hashCode += getItemCount();
        if (getItems() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getItems());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getItems(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getJobErrors() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getJobErrors());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getJobErrors(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getJobNotes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getJobNotes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getJobNotes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getJobNumber();
        if (getJobStatus() != null) {
            _hashCode += getJobStatus().hashCode();
        }
        if (getJobStops() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getJobStops());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getJobStops(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getJobType() != null) {
            _hashCode += getJobType().hashCode();
        }
        if (getNotes() != null) {
            _hashCode += getNotes().hashCode();
        }
        if (getPickupDate() != null) {
            _hashCode += getPickupDate().hashCode();
        }
        if (getPods() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPods());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPods(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPrice() != null) {
            _hashCode += getPrice().hashCode();
        }
        if (getReadyDate() != null) {
            _hashCode += getReadyDate().hashCode();
        }
        if (getReferenceNumbers() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getReferenceNumbers());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getReferenceNumbers(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getScannings() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getScannings());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getScannings(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getScheduledDeliveryDate() != null) {
            _hashCode += getScheduledDeliveryDate().hashCode();
        }
        if (getScheduledPickupDate() != null) {
            _hashCode += getScheduledPickupDate().hashCode();
        }
        if (getServiceDescription() != null) {
            _hashCode += getServiceDescription().hashCode();
        }
        if (getServiceLevel() != null) {
            _hashCode += getServiceLevel().hashCode();
        }
        if (getSignatures() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSignatures());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSignatures(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getValidatedHash() != null) {
            _hashCode += getValidatedHash().hashCode();
        }
        if (getVehicle() != null) {
            _hashCode += getVehicle().hashCode();
        }
        _hashCode += new Double(getVolume()).hashCode();
        _hashCode += new Double(getWeight()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Job.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "Job"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("account");
        elemField.setXmlName(new javax.xml.namespace.QName("", "account"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "Account"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bookedBy");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bookedBy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bookedDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bookedDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cancelledDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cancelledDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chargedDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "chargedDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("closeTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "closeTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cubedItems");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cubedItems"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "CubedItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cubicWeight");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cubicWeight"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deliveryDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deliveryDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dispatchedDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dispatchedDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docketNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "docketNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("instructions");
        elemField.setXmlName(new javax.xml.namespace.QName("", "instructions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itemCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "itemCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("items");
        elemField.setXmlName(new javax.xml.namespace.QName("", "items"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "Item"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jobErrors");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jobErrors"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "JobError"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jobNotes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jobNotes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "Note"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jobNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jobNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jobStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jobStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jobStops");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jobStops"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "JobStop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jobType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jobType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "notes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pickupDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pickupDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pods");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pods"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "POD"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("price");
        elemField.setXmlName(new javax.xml.namespace.QName("", "price"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "Price"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("readyDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "readyDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenceNumbers");
        elemField.setXmlName(new javax.xml.namespace.QName("", "referenceNumbers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scannings");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scannings"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "Scanning"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scheduledDeliveryDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scheduledDeliveryDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scheduledPickupDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scheduledPickupDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serviceDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceLevel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serviceLevel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("signatures");
        elemField.setXmlName(new javax.xml.namespace.QName("", "signatures"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "ElectronicSignature"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("validatedHash");
        elemField.setXmlName(new javax.xml.namespace.QName("", "validatedHash"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vehicle");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vehicle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "Vehicle"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("volume");
        elemField.setXmlName(new javax.xml.namespace.QName("", "volume"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("weight");
        elemField.setXmlName(new javax.xml.namespace.QName("", "weight"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
